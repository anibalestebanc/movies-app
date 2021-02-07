package com.imagemaker.login.data.datasource

import kotlinx.coroutines.flow.Flow

/**
 * Created by Anibal Cortez on 29-01-21.
 */
interface LoginRemoteDataSource {
    fun doLogin(username: String, password: String): Flow<Boolean>
}