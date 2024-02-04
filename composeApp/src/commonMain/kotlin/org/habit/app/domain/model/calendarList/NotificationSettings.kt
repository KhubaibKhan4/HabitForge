package org.habit.app.domain.model.calendarList


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NotificationSettings(
    @SerialName("notifications")
    val notifications: List<Notification>
)