package com.nilhcem.smarthome.androidthings.data.fan

import android.arch.lifecycle.LiveData
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class FanLiveData @Inject constructor(val firebase: DatabaseReference) : LiveData<FanState>() {

    companion object {
        private val TAG = FanLiveData::class.java.simpleName!!
        private val FIREBASE_FAN_ON = "fan/on"
    }

    private val valueEventListener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val newValue = snapshot.getValue(Boolean::class.java)
            Log.d(TAG, "onDataChange (value=$newValue)")
            value = FanState(newValue)
        }

        override fun onCancelled(error: DatabaseError) {
            Log.w(TAG, "onCancelled", error.toException())
        }
    }

    override fun onActive() {
        firebase.child(FIREBASE_FAN_ON).addValueEventListener(valueEventListener)
    }

    override fun onInactive() {
        firebase.child(FIREBASE_FAN_ON).removeEventListener(valueEventListener)
    }
}
