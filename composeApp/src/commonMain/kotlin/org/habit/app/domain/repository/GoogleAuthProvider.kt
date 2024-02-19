package org.habit.app.domain.repository

import androidx.compose.runtime.Composable
import org.habit.app.data.repository.GoogleAuthUiProvider

interface GoogleAuthProvider {
    @Composable
    fun getUiProvider(): GoogleAuthUiProvider
    suspend fun signOut()
}