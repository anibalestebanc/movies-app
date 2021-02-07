package com.imagemaker.login.data.repository

import com.imagemaker.login.data.datasource.LoginRemoteDataSource
import com.imagemaker.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Anibal Cortez on 29-01-21.
 */
class LoginRepositoryImpl(private val localDataSource: LoginRemoteDataSource) : LoginRepository {

    override fun doLogin(username: String, password: String): Flow<Boolean> =
        localDataSource.doLogin(username, password)


}