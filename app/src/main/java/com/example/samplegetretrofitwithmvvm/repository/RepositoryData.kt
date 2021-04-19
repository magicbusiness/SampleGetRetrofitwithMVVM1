package com.example.samplegetretrofitwithmvvm.repository

import com.example.samplegetretrofitwithmvvm.module.ModuleRetro
import com.example.samplegetretrofitwithmvvm.network.ObjectRetro
import retrofit2.Response

class RepositoryData
{
    // Implement Object
    suspend fun multiData(auth: String, token: String, userId: Int, options: Map<String, String>): Response<List<ModuleRetro>>
    {
        return ObjectRetro.getInterface.getMultiData(auth, token, userId, options)
    }
}