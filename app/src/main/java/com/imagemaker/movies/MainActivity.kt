package com.imagemaker.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.network.NetworkHelper
import com.imagemaker.checkversion.data.AppConfigRepositoryImpl
import com.imagemaker.checkversion.data.mapper.AppConfigMapper
import com.imagemaker.checkversion.data.remote.AppConfigApi
import com.imagemaker.checkversion.data.remote.AppConfigFactory
import com.imagemaker.checkversion.data.remote.RemoteAppConfigImpl
import com.imagemaker.checkversion.data.source.RemoteAppConfig
import com.imagemaker.checkversion.domain.AppConfigRepository
import com.imagemaker.checkversion.presentation.GetAppConfigUseCase
import com.imagemaker.login.getViewModel
import com.imagemaker.movies.presentation.SplashViewModel
import com.imagemaker.movies.presentation.SplashViewModel.*
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private val networkHelper: NetworkHelper by lazy {
        NetworkHelper(this)
    }

    private val appConfigApi: AppConfigApi by lazy {
        AppConfigFactory(this).makeService()
    }
    private val remoteAppConfig: RemoteAppConfig by lazy {
        RemoteAppConfigImpl(appConfigApi)
    }
    private val mapper: AppConfigMapper = AppConfigMapper()

    private val repository: AppConfigRepository by lazy {
        AppConfigRepositoryImpl(remoteAppConfig,mapper)
    }

   private val getAppConfigUseCase: GetAppConfigUseCase by lazy {
       GetAppConfigUseCase(repository)
   }

    private val viewModel: SplashViewModel by lazy {
        getViewModel { SplashViewModel(getAppConfigUseCase, networkHelper) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModel()
        viewModel.checkConnection()
    }

    private fun setUpViewModel() {
        lifecycleScope.launchWhenCreated {
            viewModel.model.collect {
                renderUiState(it)
            }
        }
    }

    private fun renderUiState(uiState: SplashUiState) {
        when (uiState) {
            SplashUiState.ConnectionErrorUiState -> showConnectionError()
            SplashUiState.UpdateAppUiState -> showUpdateApp()
            SplashUiState.DisplayLogin -> displayLogin()
            SplashUiState.DisplayHome -> displayHome()
            SplashUiState.DefaultErrorUiState -> showDefaultError()
        }
    }

    private fun showUpdateApp(){

    }
    private fun showDefaultError(){

    }
    private fun showConnectionError(){

    }

    private fun displayHome(){

    }

    private fun displayLogin(){

    }

}