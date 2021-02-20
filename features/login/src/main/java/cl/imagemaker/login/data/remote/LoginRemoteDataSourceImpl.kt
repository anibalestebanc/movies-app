package cl.imagemaker.login.data.remote

import cl.imagemaker.login.data.remote.model.DataLoginUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Anibal Cortez on 29-01-21.
 */
class LoginRemoteDataSourceImpl(private val loginApi: LoginRestApi) :
    cl.imagemaker.login.data.source.LoginRemoteDataSource {


    override fun doLogin(username: String, password: String): Flow<Boolean> = flow {
        val dataLoginUser = DataLoginUser("anibalcortez","12345")
        val request = loginApi.getMovies(dataLoginUser)
        print(request)
        emit(true)
    }

}