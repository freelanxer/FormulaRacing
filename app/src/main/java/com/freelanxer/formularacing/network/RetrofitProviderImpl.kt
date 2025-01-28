package com.freelanxer.formularacing.network

import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val contentType = "Content-Type"
private const val contentTypeValue = "application/json"
private const val BASE_URL = "https://api.openf1.org/v1/"

class RetrofitProviderImpl : RetrofitProvider {

    private val headerInterceptor = Interceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder()
            .header(contentType, contentTypeValue)
            .method(original.method, original.body)
            .build()
        chain.proceed(request)
    }

    private val loggerInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    override operator fun invoke(): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggerInterceptor)
            .connectionSpecs(
                listOf(ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT),
            )
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}