package com.imagemaker.checkversion.data.mapper

import com.imagemaker.checkversion.data.remote.model.RemoteAppConfigResponse
import com.imagemaker.checkversion.domain.model.AppConfig

class AppConfigMapper {

    fun RemoteAppConfigResponse.fromRemoteToDomain() = AppConfig(
        appVersion = appVersion
    )
}