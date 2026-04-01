package com.litecashtop.weather_flow

import android.app.Application
import com.litecashtop.weather_flow.di.weatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(weatherModule)
        }
    }

}

