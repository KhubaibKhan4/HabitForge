package org.habit.app.domain.model.calendarList


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Notification(
    @SerialName("method")
    val method: String,
    @SerialName("type")
    val type: String
)