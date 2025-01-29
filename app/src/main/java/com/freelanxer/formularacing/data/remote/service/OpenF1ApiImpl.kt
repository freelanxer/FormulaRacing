package com.freelanxer.formularacing.data.remote.service

import com.freelanxer.formularacing.model.sessions.RacingSession
import com.freelanxer.formularacing.network.RetrofitProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OpenF1ApiImpl(
    private val retrofitProvider: RetrofitProvider
) : OpenF1Api {

    private val service by lazy {
        retrofitProvider.invoke().create(OpenF1ApiService::class.java)
    }

    override suspend fun queryRacingSessions(
        sessionKey: Int?,
        year: Int?
    ): Result<List<RacingSession>> {
        return withContext(Dispatchers.Default) {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    service.requestRacingSessions(
                        sessionKey = sessionKey,
                        year = year,
                    )
                }
            }
        }
    }
}