package com.nilhcem.smarthome.androidthings.core.dagger

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.nilhcem.smarthome.androidthings.core.dagger.scope.AppScope
import com.nilhcem.smarthome.androidthings.core.dagger.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class])
class AppModule {

    @AppScope @Provides fun provideDatabaseReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference!!
    }
}
