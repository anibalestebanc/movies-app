package com.imagemaker.login.domain.usecase

import com.imagemaker.login.domain.repository.LoginRepository

/**
 * Created by Anibal Cortez on 29-01-21.
 */
class LoginUseCase(private val repository: LoginRepository) {
    fun invoke(username: String, password: String): Boolean = repository.doLogin(username, password)
}