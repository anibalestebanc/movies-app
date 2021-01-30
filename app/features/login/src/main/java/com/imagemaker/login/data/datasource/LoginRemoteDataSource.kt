package com.imagemaker.login.data.datasource

/**
 * Created by Anibal Cortez on 29-01-21.
 */
interface LoginRemoteDataSource {
    fun doLogin(username: String, password: String): Boolean
}