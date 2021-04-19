package com.example.samplegetretrofitwithmvvm.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ObjectRetro
{
    // Implement Interceptor
    private var client = OkHttpClient.Builder().apply {
        addInterceptor(InterceptorRetro())
    }.build()

    // Setting Link and Interceptor
    private val data by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Make Initialization Interface
    val getInterface: InterfaceRetro by lazy {
        data.create(InterfaceRetro::class.java)
    }
}