package com.freelanxer.formularacing.di

import com.freelanxer.formularacing.data.remote.service.OpenF1ApiService
import com.freelanxer.formularacing.network.RetrofitProvider
import com.freelanxer.formularacing.network.RetrofitProviderImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object OpenF1ServiceModule {
    operator fun invoke(overrideModules: List<Module> = emptyList()): List<Module> {
        val module =
            module {
                singleOf(::RetrofitProviderImpl).bind<RetrofitProvider>()
                single { get<RetrofitProvider>().invoke().create(OpenF1ApiService::class.java) }
            }
        return listOf(module) + overrideModules
    }
}