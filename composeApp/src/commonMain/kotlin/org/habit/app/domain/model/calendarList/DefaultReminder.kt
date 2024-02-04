package org.habit.app.domain.model.calendarList


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DefaultReminder(
    @SerialName("method")
    val method: String,
    @SerialName("minutes")
    val minutes: Int
)