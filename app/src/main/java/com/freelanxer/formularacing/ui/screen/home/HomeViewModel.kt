package com.freelanxer.formularacing.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freelanxer.formularacing.data.remote.ApiResult
import com.freelanxer.formularacing.data.remote.repository.OpenF1ApiRepository
import com.freelanxer.formularacing.model.sessions.RacingSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val openF1ApiRepository: OpenF1ApiRepository
) : ViewModel() {

    private val _sessionList = MutableStateFlow<List<RacingSession>>(emptyList())
    val sessionList = _sessionList.asStateFlow()

    init {
        requestSessions()
    }

    private fun requestSessions() {
        viewModelScope.launch {
            openF1ApiRepository.queryRacingSessions().collect { result ->
                when (result) {
                    is ApiResult.Success -> {
                        _sessionList.update {
                            result.data?.sessionList ?: emptyList()
                        }
                    }

                    is ApiResult.Fail -> {

                    }
                }
            }
        }
    }

}