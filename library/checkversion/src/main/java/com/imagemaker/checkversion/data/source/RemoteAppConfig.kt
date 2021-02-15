package com.imagemaker.checkversion.data.source

import com.imagemaker.checkversion.data.remote.model.RemoteAppConfigResponse
import kotlinx.coroutines.flow.Flow

interface RemoteAppConfig {
    fun getAppConfig(): Flow<RemoteAppConfigResponse>
}