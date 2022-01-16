package com.example.stopwatch_mvvm.view.viewmodel

import com.example.stopwatch_mvvm.data.StopwatchState
import com.example.stopwatch_mvvm.data.ITimestampProvider

class ElapsedTimeCalculator(
    private val ITimestampProvider: ITimestampProvider,
) : IElapsedTimeCalculator {

    override fun calculate(state: StopwatchState.Running): Long {
        val currentTimestamp = ITimestampProvider.getMilliseconds()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}