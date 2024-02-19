package org.habit.app.domain.model.user

data class GoogleUser(
    val idToken: String,
    val displayName: String,
    val profileUrl: String,
)
