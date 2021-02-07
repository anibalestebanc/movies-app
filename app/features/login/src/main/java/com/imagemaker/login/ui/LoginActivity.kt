package com.imagemaker.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.imagemaker.login.data.datasource.LoginRemoteDataSource
import com.imagemaker.login.data.remote.LoginApiFactory
import com.imagemaker.login.data.remote.LoginRemoteDataSourceImpl
import com.imagemaker.login.data.repository.LoginRepositoryImpl
import com.imagemaker.login.databinding.LoginActivityBinding
import com.imagemaker.login.domain.repository.LoginRepository
import com.imagemaker.login.domain.usecase.LoginUseCase
import com.imagemaker.login.getViewModel
import com.imagemaker.login.presentation.LoginViewModel
import kotlinx.coroutines.flow.collect

/**
 * Created by Anibal Cortez on 29-01-21.
 */
class LoginActivity : AppCompatActivity() {

    private var binding: LoginActivityBinding? = null

    private val loginApiFactory = LoginApiFactory(this)

    private val localDataSource: LoginRemoteDataSource by lazy {
        LoginRemoteDataSourceImpl(loginApiFactory.makeService())
    }
    private val repository: LoginRepository by lazy {
        LoginRepositoryImpl(localDataSource)
    }
    private val loginUseCase : LoginUseCase by lazy {
        LoginUseCase(repository)
    }

    private val viewModel: LoginViewModel by lazy {
        getViewModel { LoginViewModel(loginUseCase) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginActivityBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        setUpViewModel()
        setUpListener()
    }

    private fun setUpListener() {
        binding?.loginButton?.setOnClickListener {
            viewModel.loginAction(binding?.usernameEditText.toString(),binding?.passwordEditText.toString())
        }
    }

    private fun setUpViewModel() {
        lifecycleScope.launchWhenCreated {
            viewModel.model.collect {
                renderUiState(it)
            }
        }
    }

    private fun renderUiState(uiState : LoginViewModel.LoginUiState){
        when(uiState){
            LoginViewModel.LoginUiState.Loading -> setLoadingView()
            LoginViewModel.LoginUiState.Error -> setErrorView()
            LoginViewModel.LoginUiState.Success -> setSuccessView()
        }
    }

    private fun setLoadingView(){
        binding?.loadingProgressBar?.apply {
            visibility = View.VISIBLE
        }
    }

    private fun setSuccessView(){
        binding?.loadingProgressBar?.apply {
            visibility = View.GONE
        }
    }
    private fun setErrorView(){
        binding?.loadingProgressBar?.apply {
            visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}