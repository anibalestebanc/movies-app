package com.imagemaker.login.data.remote

import com.imagemaker.login.data.datasource.LoginRemoteDataSource
import com.imagemaker.login.data.remote.model.DataLoginUser
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Anibal Cortez on 29-01-21.
 */
class LoginRemoteDataSourceImpl(private val loginApi: LoginRestApi) : LoginRemoteDataSource {


    override fun doLogin(username: String, password: String): Flow<Boolean> = flow {
        val dataLoginUser = DataLoginUser("anibalcortez","12345")
        val request = loginApi.getMovies(dataLoginUser)
        print(request)
        emit(true)
    }

}