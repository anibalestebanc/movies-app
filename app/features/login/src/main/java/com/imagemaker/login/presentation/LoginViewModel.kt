package com.imagemaker.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imagemaker.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Created by Anibal Cortez on 29-01-21.
 */
@ExperimentalCoroutinesApi
class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    sealed class LoginUiState {
        object Default : LoginUiState()
        object Loading : LoginUiState()
        object Error : LoginUiState()
        object Success : LoginUiState()
    }

    private val _model = MutableStateFlow<LoginUiState>(LoginUiState.Default)
    val model: StateFlow<LoginUiState> get() = _model


    fun loginAction(username: String, password: String) {
        viewModelScope.launch {
            loginUseCase.invoke(username, password)
                .onStart { _model.value = LoginUiState.Loading }
                .catch {
                    _model.value = LoginUiState.Error
                }
                .onCompletion { _model.value = LoginUiState.Default }
                .collect {
                    _model.value = LoginUiState.Success
                }
        }
    }

}