package com.imagemaker.login.data.remote

import android.content.Context
import com.example.network.ApiClient
import com.imagemaker.login.BuildConfig


class LoginApiFactory(private val appContext: Context) : ApiClient<LoginRestApi>() {

    fun makeService(): LoginRestApi = buildService()

    override fun getBaseUrl(): String = BuildConfig.URL_BASE

    override fun getApiService(): Class<LoginRestApi> = LoginRestApi::class.java

    override fun getContext(): Context = appContext

}