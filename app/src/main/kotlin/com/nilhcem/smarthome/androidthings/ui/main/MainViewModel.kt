package com.nilhcem.smarthome.androidthings.ui.main

import android.arch.lifecycle.ViewModel
import com.nilhcem.smarthome.androidthings.data.fan.FanLiveData
import com.nilhcem.smarthome.androidthings.data.lights.LightsLiveData
import javax.inject.Inject

class MainViewModel @Inject constructor(val fanLiveData: FanLiveData, val lightsLiveData: LightsLiveData) : ViewModel()
