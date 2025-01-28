package com.freelanxer.formularacing.data.remote.service

import com.freelanxer.formularacing.model.sessions.RacingSession

interface OpenF1Api {
    suspend fun queryRacingSessions(
        year: Int? = null
    ): Result<List<RacingSession>>
}