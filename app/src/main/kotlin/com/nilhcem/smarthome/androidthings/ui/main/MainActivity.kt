package com.nilhcem.smarthome.androidthings.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var boardComponents: MainBoardComponents
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(boardComponents)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.fanLiveData.observe(this, Observer { fanState ->
            boardComponents.setFanOn(fanState?.isOn ?: false)
        })

        viewModel.lightsLiveData.observe(this, Observer { lights ->
            lights?.let {
                boardComponents.setLights(it)
            }
        })
    }
}
