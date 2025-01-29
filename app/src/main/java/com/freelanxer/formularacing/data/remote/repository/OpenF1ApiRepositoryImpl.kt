package com.freelanxer.formularacing.data.remote.repository

import com.freelanxer.formularacing.data.remote.ApiResult
import com.freelanxer.formularacing.data.remote.service.OpenF1Api
import com.freelanxer.formularacing.model.sessions.RacingSessionResponseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class OpenF1ApiRepositoryImpl(
    private val api: OpenF1Api
) : OpenF1ApiRepository {

    override suspend fun queryRacingSessions(year: Int?): Flow<ApiResult<RacingSessionResponseEntity>> {
        val apiResult = withContext(Dispatchers.IO) {
            api.queryRacingSessions(year).fold(
                onSuccess = {
                    ApiResult.Success(result = RacingSessionResponseEntity(sessionList = it))
                },
                onFailure = {
                    ApiResult.Fail(exception = it)
                }
            )
        }
        return flow {
            emit(apiResult)
        }
    }
}