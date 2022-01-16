package com.example.stopwatch_mvvm.view.viewmodel

import com.example.stopwatch_mvvm.data.StopwatchState

interface IStopwatchStateHolder {
    var currentState: StopwatchState
    fun start()
    fun pause()
    fun stop()
    fun getStringTimeRepresentation(): String
}