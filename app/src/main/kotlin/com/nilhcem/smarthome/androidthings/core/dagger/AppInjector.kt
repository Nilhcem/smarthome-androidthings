package com.nilhcem.smarthome.androidthings.core.dagger

import com.nilhcem.smarthome.androidthings.App

object AppInjector {

    fun init(app: App) {
        DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
                .inject(app)
    }
}
