package cl.imagemaker.login.domain.repository

import kotlinx.coroutines.flow.Flow


/**
 * Created by Anibal Cortez on 29-01-21.
 */
interface LoginRepository {
    fun doLogin(username: String, password: String): Flow<Boolean>
}