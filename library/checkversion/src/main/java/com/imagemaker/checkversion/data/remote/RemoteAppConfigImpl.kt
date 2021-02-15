package com.imagemaker.checkversion.data.remote

import com.imagemaker.checkversion.data.remote.model.RemoteAppConfigResponse
import com.imagemaker.checkversion.data.source.RemoteAppConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteAppConfigImpl(private val appConfigApi: AppConfigApi) : RemoteAppConfig {

    override fun getAppConfig(): Flow<RemoteAppConfigResponse> = flow {
        emit(
            appConfigApi .getAppConfig()
        )
    }
}