package com.nilhcem.smarthome.androidthings.core.dagger

import com.nilhcem.smarthome.androidthings.App
import com.nilhcem.smarthome.androidthings.core.dagger.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjectionModule

@AppScope
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        AndroidBindingModule::class)
)
interface AppComponent {
    fun inject(app: App)
}
