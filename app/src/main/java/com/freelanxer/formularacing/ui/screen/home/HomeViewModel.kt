package com.freelanxer.formularacing.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freelanxer.formularacing.data.remote.repository.OpenF1ApiRepository
import com.freelanxer.formularacing.model.sessions.SessionMeeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val openF1ApiRepository: OpenF1ApiRepository
) : ViewModel() {

    private val _meetingList = MutableStateFlow<List<SessionMeeting>>(emptyList())
    val meetingList = _meetingList.asStateFlow()

    init {
        requestSessions()
    }

    private fun requestSessions() {
        viewModelScope.launch {
            val result = openF1ApiRepository.queryRacingSessions()
            result.onFailure {
                it.printStackTrace()
            }
            _meetingList.value = result.getOrNull()
                ?.reversed()
                ?.let {
                it.groupBy { session -> session.meetingKey }
                    .map { (meetingKey, sessions) ->
                        val firstSession = sessions.first()
                        SessionMeeting(
                            meetingKey = meetingKey,
                            meetingName = firstSession.countryName,
                            locationName = firstSession.location,
                            countryCode = firstSession.countryCode,
                            year = firstSession.year,
                            circuitKey = firstSession.circuitKey,
                            sessionList = sessions.reversed()
                        )
                    }
            } ?: emptyList()
        }
    }

}