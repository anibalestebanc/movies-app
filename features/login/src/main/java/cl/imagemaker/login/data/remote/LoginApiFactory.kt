package cl.imagemaker.login.data.remote

import android.content.Context
import cl.imagemaker.login.BuildConfig
import com.example.network.ApiClient

class LoginApiFactory(private val appContext: Context) : ApiClient<LoginRestApi>() {

    fun makeService(): LoginRestApi = buildService()

    override fun getBaseUrl(): String = BuildConfig.URL_BASE

    override fun getApiService(): Class<LoginRestApi> = LoginRestApi::class.java

    override fun getContext(): Context = appContext

}