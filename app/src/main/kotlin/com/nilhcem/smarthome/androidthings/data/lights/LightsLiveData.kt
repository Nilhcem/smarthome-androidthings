package com.nilhcem.smarthome.androidthings.data.lights

import android.arch.lifecycle.LiveData
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class LightsLiveData @Inject constructor(val firebase: DatabaseReference) : LiveData<Lights>() {

    companion object {
        private val TAG = Lights::class.java.simpleName!!
        private val FIREBASE_LIGHTS = "lights"
        private val FIREBASE_LIGHTS_ON = "on"
        private val FIREBASE_LIGHTS_RGB = "spectrumRGB"
    }

    private val valueEventListener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val isOn = snapshot.child(FIREBASE_LIGHTS_ON).getValue(Boolean::class.java) ?: false
            val spectrumRGB = snapshot.child(FIREBASE_LIGHTS_RGB).getValue(Int::class.java) ?: 0
            val lights = Lights(isOn, spectrumRGB)
            Log.d(TAG, "onDataChange (value=$lights)")
            value = lights
        }

        override fun onCancelled(error: DatabaseError) {
            Log.w(TAG, "onCancelled", error.toException())
        }
    }

    override fun onActive() {
        super.onActive()
        firebase.child(FIREBASE_LIGHTS).addValueEventListener(valueEventListener)
    }

    override fun onInactive() {
        super.onInactive()
        firebase.child(FIREBASE_LIGHTS).removeEventListener(valueEventListener)
    }
}
