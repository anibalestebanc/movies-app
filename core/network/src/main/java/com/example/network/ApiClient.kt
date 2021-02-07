package com.example.network

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class ApiClient<T> {

    private val client: OkHttpClient by lazy { createOkHttpClient() }
    private val retrofit: Retrofit by lazy { createRetrofitService() }

    fun buildService(): T {
        return retrofit.create(getApiService())
    }

    abstract fun getApiService(): Class<T>

    abstract fun getBaseUrl(): String

    abstract fun getContext() : Context

    private fun createRetrofitService(): Retrofit =
        Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    private fun createOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        if(BuildConfig.FLAVOR.equals("dummy")){
            client.addInterceptor(FakeInterceptor(getContext()))
        }
        return client.build()
    }
}