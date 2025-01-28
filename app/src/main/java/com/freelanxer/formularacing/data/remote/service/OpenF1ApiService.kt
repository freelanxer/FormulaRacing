package com.freelanxer.formularacing.data.remote.service

import com.freelanxer.formularacing.model.sessions.RacingSession
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenF1ApiService {
    @GET("sessions")
    suspend fun requestRacingSessions(
        @Query("year") year: Int? = null
    ): List<RacingSession>
}