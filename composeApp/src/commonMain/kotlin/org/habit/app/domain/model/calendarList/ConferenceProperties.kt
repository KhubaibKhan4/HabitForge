package org.habit.app.domain.model.calendarList


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConferenceProperties(
    @SerialName("allowedConferenceSolutionTypes")
    val allowedConferenceSolutionTypes: List<String>
)