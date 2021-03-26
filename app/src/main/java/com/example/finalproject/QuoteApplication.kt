package com.example.finalproject

import android.app.Application
import com.example.finalproject.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class QuoteApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        //Starting Koin
        startKoin {
            androidLogger()
            androidContext(this@QuoteApplication)
            modules(dataModule)
        }
    }
}