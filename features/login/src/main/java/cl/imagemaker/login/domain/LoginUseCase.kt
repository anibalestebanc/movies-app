package cl.imagemaker.login.domain

import cl.imagemaker.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow


/**
 * Created by Anibal Cortez on 29-01-21.
 */
class LoginUseCase(private val repository: LoginRepository) {
    fun invoke(username: String, password: String): Flow<Boolean> = repository.doLogin(username, password)
}