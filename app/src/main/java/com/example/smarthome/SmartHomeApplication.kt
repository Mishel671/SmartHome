package com.example.smarthome

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm

@HiltAndroidApp
class SmartHomeApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}