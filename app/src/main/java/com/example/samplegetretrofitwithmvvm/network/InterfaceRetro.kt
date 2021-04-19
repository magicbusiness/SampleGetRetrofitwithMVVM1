package com.example.samplegetretrofitwithmvvm.network

import com.example.samplegetretrofitwithmvvm.module.ModuleRetro
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface InterfaceRetro
{
    @GET("posts")
    suspend fun getMultiData(
        // Header for Authentication
        @Header("Authentication") auth: String,
        @Header("Token") token: String,

        // Query Map
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<ModuleRetro>>
}