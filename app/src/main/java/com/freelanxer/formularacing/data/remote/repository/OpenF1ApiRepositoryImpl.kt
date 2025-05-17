package com.freelanxer.formularacing.data.remote.repository

import com.freelanxer.formularacing.data.remote.service.OpenF1Api
import com.freelanxer.formularacing.model.sessions.RacingSessionResponseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class OpenF1ApiRepositoryImpl(
    private val api: OpenF1Api
) : OpenF1ApiRepository {

    override suspend fun queryRacingSessions(
        sessionKey: Int?,
        year: Int?
    ): Flow<Result<RacingSessionResponseEntity>> {
        val apiResult = withContext(Dispatchers.IO) {
            api.queryRacingSessions(sessionKey, year).fold(
                onSuccess = {
                    Result.success(RacingSessionResponseEntity(it))
                },
                onFailure = {
                    Result.failure(it)
                }
            )
        }
        return flow {
            emit(apiResult)
        }
    }
}