package com.freelanxer.formularacing.data.remote.repository

import com.freelanxer.formularacing.data.remote.ApiResult
import com.freelanxer.formularacing.model.sessions.RacingSessionResponseEntity
import kotlinx.coroutines.flow.Flow

interface OpenF1ApiRepository {

    suspend fun queryRacingSessions(
        sessionKey: Int? = null,
        year: Int? = null
    ): Flow<ApiResult<RacingSessionResponseEntity>>

}