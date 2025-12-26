package com.freelanxer.formularacing.data.remote.repository

import com.freelanxer.formularacing.data.remote.service.OpenF1ApiService
import com.freelanxer.formularacing.model.sessions.RacingSession

class OpenF1ApiRepositoryImpl(
    private val service: OpenF1ApiService
) : OpenF1ApiRepository {

    override suspend fun queryRacingSessions(
        sessionKey: Int?,
        year: Int?
    ): Result<List<RacingSession>> {
        return runCatching {
            service.requestRacingSessions(sessionKey, year)
        }
    }
}