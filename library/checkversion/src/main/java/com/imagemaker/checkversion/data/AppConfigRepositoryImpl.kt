package com.imagemaker.checkversion.data

import com.imagemaker.checkversion.data.mapper.AppConfigMapper
import com.imagemaker.checkversion.data.source.RemoteAppConfig
import com.imagemaker.checkversion.domain.AppConfigRepository
import com.imagemaker.checkversion.domain.model.AppConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppConfigRepositoryImpl(
    private val remoteAppConfig: RemoteAppConfig,
    private val mapper: AppConfigMapper
) : AppConfigRepository {
    override fun getAppConfig(): Flow<AppConfig> = remoteAppConfig.getAppConfig()
        .map {
            with(mapper) { it.fromRemoteToDomain() }
        }
}