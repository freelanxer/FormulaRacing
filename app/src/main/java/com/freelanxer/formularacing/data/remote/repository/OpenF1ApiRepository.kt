package com.freelanxer.formularacing.data.remote.repository

import com.freelanxer.formularacing.model.sessions.RacingSession

interface OpenF1ApiRepository {

    suspend fun queryRacingSessions(
        sessionKey: Int? = null,
        year: Int? = null
    ): Result<List<RacingSession>>

}