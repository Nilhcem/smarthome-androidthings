package com.nilhcem.smarthome.androidthings.core.android.arch

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nilhcem.smarthome.androidthings.core.dagger.scope.AppScope
import javax.inject.Inject
import javax.inject.Provider

@AppScope
class ViewModelFactory @Inject constructor(private val creators: Map<@JvmSuppressWildcards Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        if (creator == null) {
            throw IllegalArgumentException("unknown model class " + modelClass)
        }

        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
