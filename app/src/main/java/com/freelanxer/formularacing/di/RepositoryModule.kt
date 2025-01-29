package com.freelanxer.formularacing.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.freelanxer.formularacing.data.remote.repository.OpenF1ApiRepository
import com.freelanxer.formularacing.data.remote.repository.OpenF1ApiRepositoryImpl
import org.koin.dsl.bind

object RepositoryModule {
    operator fun invoke() =
        module {
            factoryOf(::OpenF1ApiRepositoryImpl).bind<OpenF1ApiRepository>()
        }
}