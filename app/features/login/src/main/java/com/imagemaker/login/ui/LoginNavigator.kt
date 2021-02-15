package com.imagemaker.login.ui

import android.content.Context
import com.example.home.HomeActivity

object LoginNavigator {

    fun navigateToHome(context: Context) {
        HomeActivity.launch(context)
    }

}