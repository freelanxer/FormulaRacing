package com.freelanxer.formularacing.di

import com.freelanxer.formularacing.data.remote.service.OpenF1Api
import com.freelanxer.formularacing.data.remote.service.OpenF1ApiImpl
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
                singleOf(::OpenF1ApiImpl).bind<OpenF1Api>()
            }
        return listOf(module) + overrideModules
    }
}