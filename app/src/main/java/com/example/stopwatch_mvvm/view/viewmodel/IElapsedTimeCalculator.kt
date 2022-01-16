package com.example.stopwatch_mvvm.view.viewmodel

import com.example.stopwatch_mvvm.data.StopwatchState

interface IElapsedTimeCalculator {
    fun calculate(state: StopwatchState.Running): Long
}