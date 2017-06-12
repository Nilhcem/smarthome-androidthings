package com.nilhcem.smarthome.androidthings.core.dagger

import com.nilhcem.smarthome.androidthings.core.dagger.scope.ActivityScope
import com.nilhcem.smarthome.androidthings.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
