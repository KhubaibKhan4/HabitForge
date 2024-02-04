package org.habit.app.domain.model.calendarList


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CalendarList(
    @SerialName("accessRole")
    val accessRole: String,
    @SerialName("backgroundColor")
    val backgroundColor: String,
    @SerialName("colorId")
    val colorId: String,
    @SerialName("conferenceProperties")
    val conferenceProperties: ConferenceProperties,
    @SerialName("defaultReminders")
    val defaultReminders: List<DefaultReminder>,
    @SerialName("etag")
    val etag: String,
    @SerialName("foregroundColor")
    val foregroundColor: String,
    @SerialName("id")
    val id: String,
    @SerialName("kind")
    val kind: String,
    @SerialName("notificationSettings")
    val notificationSettings: NotificationSettings,
    @SerialName("primary")
    val primary: Boolean,
    @SerialName("selected")
    val selected: Boolean,
    @SerialName("summary")
    val summary: String,
    @SerialName("timeZone")
    val timeZone: String
)