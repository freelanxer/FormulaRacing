package com.freelanxer.formularacing.ui.screen.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freelanxer.formularacing.R
import com.freelanxer.formularacing.data.remote.repository.OpenF1ApiRepository
import com.freelanxer.formularacing.model.sessions.SessionMeeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val context: Application,
    private val openF1ApiRepository: OpenF1ApiRepository
) : ViewModel() {

    private val _meetingList = MutableStateFlow<List<SessionMeeting>>(emptyList())
    val meetingList = _meetingList.asStateFlow()

    init {
        requestSessions()
    }

    private fun requestSessions() {
        viewModelScope.launch {
            openF1ApiRepository.queryRacingSessions().collect { result ->
                result.onSuccess { entity ->
                    val sessionList = entity.sessionList?.reversed() ?: emptyList()
                    val meetingList = sessionList.groupBy { it.meetingKey }
                        .map { (meetingKey, sessions) ->
                            val firstSession = sessions.first()
                            SessionMeeting(
                                meetingKey = meetingKey,
                                meetingName = "${firstSession.countryName} ${context.getString(
                                    R.string.grand_prix)}",
                                locationName = firstSession.location,
                                countryCode = firstSession.countryCode,
                                year = firstSession.year,
                                circuitKey = firstSession.circuitKey,
                                sessionList = sessions.reversed()
                            )
                        }
                    _meetingList.update { meetingList }
                }.onFailure {

                }
            }
        }
    }

}