package com.freelanxer.formularacing.model.sessions

data class SessionMeeting(
    val meetingKey: Int? = null,
    val meetingName: String? = null,
    val locationName: String? = null,
    val countryCode: String? = null,
    val circuitKey: Int? = null,
    val year: Int? = null,
    val sessionList: List<RacingSession>? = null,
)
