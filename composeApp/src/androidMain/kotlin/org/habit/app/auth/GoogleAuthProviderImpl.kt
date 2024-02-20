package org.habit.app.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import org.habit.app.data.repository.GoogleAuthUiProvider
import org.habit.app.domain.model.user.GoogleAuthCredentials
import org.habit.app.domain.repository.GoogleAuthProvider

class GoogleAuthProviderImpl(
    private val credentials: GoogleAuthCredentials,
    private val credentialManager: CredentialManager,
) : GoogleAuthProvider {
    @Composable
    override fun getUiProvider(): GoogleAuthUiProvider {
        val activityContext = LocalContext.current
        return GoogleAuthUiProviderImpl(
            activityContext, credentialManager, credentials
        )
    }

    override suspend fun signOut() {
        credentialManager.clearCredentialState(ClearCredentialStateRequest())
    }
}