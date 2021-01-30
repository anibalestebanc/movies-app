package com.imagemaker.login.domain.repository

/**
 * Created by Anibal Cortez on 29-01-21.
 */
interface LoginRepository {
    fun doLogin(username: String, password: String): Boolean
}