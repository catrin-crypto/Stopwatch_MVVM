package com.example.stopwatch_mvvm.view.viewmodel

import com.example.stopwatch_mvvm.data.StopwatchState
import com.example.stopwatch_mvvm.data.ITimestampProvider

class StopwatchStateCalculator(
    private val timestampProvider: ITimestampProvider,
    private val elapsedTimeCalculator: IElapsedTimeCalculator,
) : IStopwatchStateCalculator {

    override fun calculateRunningState(oldState: StopwatchState): StopwatchState.Running =
        when (oldState) {
            is StopwatchState.Running -> oldState
            is StopwatchState.Paused -> {
                StopwatchState.Running(
                    startTime = timestampProvider.getMilliseconds(),
                    elapsedTime = oldState.elapsedTime
                )
            }
        }

    override fun calculatePausedState(oldState: StopwatchState): StopwatchState.Paused =
        when (oldState) {
            is StopwatchState.Running -> {
                val elapsedTime = elapsedTimeCalculator.calculate(oldState)
                StopwatchState.Paused(elapsedTime = elapsedTime)
            }
            is StopwatchState.Paused -> oldState
        }
}