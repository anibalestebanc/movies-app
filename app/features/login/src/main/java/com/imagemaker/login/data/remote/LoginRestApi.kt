package com.imagemaker.login.data.remote

import com.imagemaker.login.data.remote.model.DataLoginResponse
import com.imagemaker.login.data.remote.model.DataLoginUser
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRestApi {

    @POST("user/login")
    suspend fun getMovies(@Body loginUser: DataLoginUser): DataLoginResponse

}