package com.example.stopwatch_mvvm.view.viewmodel

import com.example.stopwatch_mvvm.data.StopwatchState

class StopwatchStateHolder(
    private val stopwatchStateCalculator: IStopwatchStateCalculator,
    private val elapsedTimeCalculator: IElapsedTimeCalculator,
    private val timestampMillisecondsFormatter: ITimestampMillisecondsFormatter
) : IStopwatchStateHolder {

    override var currentState: StopwatchState = StopwatchState.Paused(0)


    override fun start() {
        currentState = stopwatchStateCalculator.calculateRunningState(currentState)
    }

    override fun pause() {
        currentState = stopwatchStateCalculator.calculatePausedState(currentState)
    }

    override fun stop() {
        currentState = StopwatchState.Paused(0)
    }

    override fun getStringTimeRepresentation(): String {
        val elapsedTime = when (val currentState = currentState) {
            is StopwatchState.Paused -> currentState.elapsedTime
            is StopwatchState.Running -> elapsedTimeCalculator.calculate(currentState)
        }
        return timestampMillisecondsFormatter.format(elapsedTime)
    }
}