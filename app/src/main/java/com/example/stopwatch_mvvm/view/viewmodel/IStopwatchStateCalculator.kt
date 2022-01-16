package com.example.stopwatch_mvvm.view.viewmodel

import com.example.stopwatch_mvvm.data.StopwatchState

interface IStopwatchStateCalculator {
    fun calculateRunningState(oldState: StopwatchState): StopwatchState.Running
    fun calculatePausedState(oldState: StopwatchState): StopwatchState.Paused
}