package com.freelanxer.formularacing.network

import retrofit2.Retrofit

interface RetrofitProvider {
    operator fun invoke(): Retrofit
}