package com.freelanxer.formularacing.model.sessions

/**
 * Provides information about sessions.
 * A session refers to a distinct period of track activity during a Grand Prix or testing weekend
 * (practice, qualifying, sprint, race, ...).
 */
data class RacingSessionResponseEntity(
    val sessionList: List<RacingSession>? = null
)