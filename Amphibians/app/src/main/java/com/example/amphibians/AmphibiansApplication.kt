package com.example.amphibians

import android.app.Application
import com.example.amphibians.ui.data.AppContainer
import com.example.amphibians.ui.data.DefaultAppContainer

class AmphibiansApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}