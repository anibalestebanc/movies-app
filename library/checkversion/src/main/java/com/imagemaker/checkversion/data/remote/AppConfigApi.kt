package com.imagemaker.checkversion.data.remote

import com.imagemaker.checkversion.data.remote.model.RemoteAppConfigResponse
import retrofit2.http.POST

interface AppConfigApi {

    @POST("appconfig/config")
    suspend fun getAppConfig(): RemoteAppConfigResponse

}