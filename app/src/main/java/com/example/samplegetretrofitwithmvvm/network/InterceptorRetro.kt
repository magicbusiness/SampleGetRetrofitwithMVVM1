package com.example.samplegetretrofitwithmvvm.network

import okhttp3.Interceptor
import okhttp3.Response

class InterceptorRetro: Interceptor
{
    override fun intercept(chain: Interceptor.Chain): Response
    {
        val intercept = chain.request()
            .newBuilder()
            .addHeader("Sample_Head", "Sample_Header")
            .addHeader("sample_Body", "Sample_Body")
            .build()

        return chain.proceed(intercept)
    }
}