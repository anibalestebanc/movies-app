package com.imagemaker.checkversion.domain

import com.imagemaker.checkversion.domain.model.AppConfig
import kotlinx.coroutines.flow.Flow

interface AppConfigRepository {
    fun getAppConfig() : Flow<AppConfig>
}