package cl.imagemaker.login.data.remote

import cl.imagemaker.login.data.remote.model.DataLoginResponse
import cl.imagemaker.login.data.remote.model.DataLoginUser
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRestApi {

    @POST("user/login")
    suspend fun getMovies(@Body loginUser: DataLoginUser): DataLoginResponse

}