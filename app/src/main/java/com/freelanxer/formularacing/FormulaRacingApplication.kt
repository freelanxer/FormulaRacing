package com.freelanxer.formularacing

import android.app.Application
import com.freelanxer.formularacing.di.OpenF1ServiceModule
import com.freelanxer.formularacing.di.RepositoryModule
import com.freelanxer.formularacing.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FormulaRacingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoinApplication()
    }

    private fun startKoinApplication() {
        startKoin {
            androidContext(this@FormulaRacingApplication)
            modules(
                OpenF1ServiceModule() +
                        RepositoryModule() +
                        ViewModelModule()
            )
        }
    }
}