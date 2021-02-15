package com.example.network

import android.content.Context
import android.net.ConnectivityManager

class NetworkHelper(private val context: Context) {

    fun isConnected() : Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}