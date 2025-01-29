package com.freelanxer.formularacing.di

import com.freelanxer.formularacing.ui.screen.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object ViewModelModule {
    operator fun invoke() = module {
        viewModelOf(::HomeViewModel)
    }
}