package org.habit.app.data.repository

import org.habit.app.domain.model.user.GoogleUser

interface GoogleAuthUiProvider {
    suspend fun signIn(): GoogleUser?
}