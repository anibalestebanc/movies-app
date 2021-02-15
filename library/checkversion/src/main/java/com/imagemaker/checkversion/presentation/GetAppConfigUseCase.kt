package com.imagemaker.checkversion.presentation

import com.imagemaker.checkversion.domain.AppConfigRepository
import com.imagemaker.checkversion.domain.model.AppConfig
import kotlinx.coroutines.flow.Flow

class GetAppConfigUseCase(private val repository: AppConfigRepository) {
    fun invoke(): Flow<AppConfig> = repository.getAppConfig()
}