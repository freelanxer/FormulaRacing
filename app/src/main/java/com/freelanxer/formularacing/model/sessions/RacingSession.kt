package com.freelanxer.formularacing.model.sessions

import com.google.gson.annotations.SerializedName

data class RacingSession(
    /**
     * The unique identifier for the circuit where the event takes place.
     */
    @SerializedName("circuit_key") val circuitKey: Int? = null,

    /**
     * The short or common name of the circuit where the event takes place.
     */
    @SerializedName("circuit_short_name") val circuitShortName: String? = null,

    /**
     *A code that uniquely identifies the country.
     */
    @SerializedName("country_code") val countryCode: String? = null,

    /**
     * The unique identifier for the country where the event takes place.
     */
    @SerializedName("country_key") val countryKey: Int? = null,

    /**
     * The full name of the country where the event takes place.
     */
    @SerializedName("country_name") val countryName: String? = null,

    /**
     * The UTC ending date and time, in ISO 8601 format.
     */
    @SerializedName("date_end") val dateEnd: String? = null,

    /**
     * The UTC starting date and time, in ISO 8601 format.
     */
    @SerializedName("date_start") val dateStart: String? = null,

    /**
     * The difference in hours and minutes between local time at the location of the event and Greenwich Mean Time (GMT).
     */
    @SerializedName("gmt_offset") val gmtOffset: String? = null,

    /**
     * The city or geographical location where the event takes place.
     */
    @SerializedName("location") val location: String? = null,

    /**
     * The unique identifier for the meeting. Use latest to identify the latest or current meeting.
     */
    @SerializedName("meeting_key") val meetingKey: Int? = null,

    /**
     * The unique identifier for the session. Use latest to identify the latest or current session.
     */
    @SerializedName("session_key") val sessionKey: Int? = null,

    /**
     * The name of the session (Practice 1, Qualifying, Race, ...).
     */
    @SerializedName("session_name") val sessionName: String? = null,

    /**
     * The type of the session (Practice, Qualifying, Race, ...).
     */
    @SerializedName("session_type") val sessionType: String? = null,

    /**
     * The year the event takes place.
     */
    @SerializedName("year") val year: Int? = null,
)