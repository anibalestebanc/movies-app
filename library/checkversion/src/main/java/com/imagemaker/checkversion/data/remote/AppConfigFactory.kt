package com.imagemaker.checkversion.data.remote

import android.content.Context
import com.example.network.ApiClient
import com.imagemaker.checkversion.BuildConfig

class AppConfigFactory constructor(private val context: Context): ApiClient<AppConfigApi>() {

    fun makeService() : AppConfigApi = buildService()

    override fun getApiService(): Class<AppConfigApi> = AppConfigApi::class.java

    override fun getBaseUrl(): String = BuildConfig.URL_BASE

    override fun getContext(): Context = context
}