package org.habit.app.auth

import android.content.Context
import android.credentials.GetCredentialException
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import io.github.aakira.napier.Napier
import org.habit.app.data.repository.GoogleAuthUiProvider
import org.habit.app.domain.model.user.GoogleAuthCredentials
import org.habit.app.domain.model.user.GoogleUser

internal class GoogleAuthUiProviderImpl(
    private val activityContext: Context,
    private val credentialManager: CredentialManager,
    private val credentials: GoogleAuthCredentials,
) : GoogleAuthUiProvider {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override suspend fun signIn(): GoogleUser? {
        return try {
            val credential = credentialManager.getCredential(
                activityContext,
                getCredentialRequest()
            ).credential
            getGoogleUserFromCredentials(credential)
        } catch (e: GetCredentialException) {
            Napier.e("GoogleAuthUiProvider error: ${e.message}")
            null
        } catch (e: NullPointerException) {
            null
        }
    }

    private fun getGoogleUserFromCredentials(credential: Credential): GoogleUser? {
        return when {
            credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL -> {
                try {
                    val googleIdTokenCredential =
                        GoogleIdTokenCredential.createFrom(credential.data)
                    GoogleUser(
                        idToken = googleIdTokenCredential.idToken,
                        displayName = googleIdTokenCredential.displayName ?: "",
                        profileUrl = googleIdTokenCredential.profilePictureUri.toString()
                    )
                } catch (e: GoogleIdTokenParsingException) {
                    Napier.e("GoogleAuthUiProvider Received an invalid google id token response: ${e.message}")
                    null
                }
            }

            else -> null
        }
    }

    private fun getCredentialRequest(): GetCredentialRequest {
        return GetCredentialRequest.Builder()
            .addCredentialOption(getGoogleIdOption(serverClientId = credentials.serverId))
            .build()
    }

    private fun getGoogleIdOption(serverClientId: String): GetGoogleIdOption {
        return GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setAutoSelectEnabled(true)
            .setServerClientId(serverClientId)
            .build()
    }
}


