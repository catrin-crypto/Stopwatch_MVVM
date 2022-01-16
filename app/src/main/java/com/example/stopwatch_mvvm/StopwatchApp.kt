package com.example.stopwatch_mvvm

import android.app.Application
import com.example.stopwatch_mvvm.di.mainEngine
import org.koin.core.context.startKoin

class StopwatchApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { modules(mainEngine) }
    }

}