package com.example.weatherdata.di

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeatherDataApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        appInstance = this
    }

    companion object {
        var appInstance: WeatherDataApplication? = null
            private set

        @JvmStatic
        val appContext: Context
            get() = appInstance!!.applicationContext
    }
}