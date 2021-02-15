package com.imagemaker.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.NetworkHelper
import com.imagemaker.checkversion.domain.model.AppConfig
import com.imagemaker.checkversion.presentation.GetAppConfigUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class SplashViewModel(
    private val getAppConfigUseCase: GetAppConfigUseCase,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    sealed class SplashUiState() {
        object DefaultUiState : SplashUiState()
        object DefaultErrorUiState : SplashUiState()
        object ConnectionErrorUiState : SplashUiState()
        object UpdateAppUiState : SplashUiState()
        object DisplayLogin : SplashUiState()
        object DisplayHome : SplashUiState()
    }

    private val _model = MutableStateFlow<SplashUiState>(SplashUiState.DefaultUiState)
    val model: StateFlow<SplashUiState> get() = _model

    fun checkConnection() {
        if (networkHelper.isConnected())
            checkAppVersion()
        else _model.value = SplashUiState.ConnectionErrorUiState
    }

    private fun checkAppVersion() {
        viewModelScope.launch {
            getAppConfigUseCase.invoke()
                .catch { _model.value = SplashUiState.DefaultErrorUiState }
                .onCompletion { _model.value = SplashUiState.DefaultUiState }
                .collect { checkVersion(it) }
        }
    }

    private fun checkVersion(appConfig: AppConfig) {
        checkLocalUser()
    }

    private fun checkLocalUser() {
        _model.value = SplashUiState.DisplayHome
    }
}