package com.example.ironasia

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IronAsiaApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}