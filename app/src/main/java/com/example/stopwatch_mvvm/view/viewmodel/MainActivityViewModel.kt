package com.example.stopwatch_mvvm.view.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel(
    private val stopwatchStateHolder: StopwatchStateHolder,
    private val scope: CoroutineScope
) : ViewModel() {

    private var job: Job? = null
    private val mutableTicker = MutableStateFlow("")
    val ticker: StateFlow<String> = mutableTicker

    fun start() {
        if (job == null) startJob()
        stopwatchStateHolder.start()
    }

    private fun startJob() {
        scope.launch {
            while (isActive) {
                mutableTicker.value = stopwatchStateHolder.getStringTimeRepresentation()
                delay(20)
            }
        }
    }

    fun pause() {
        stopwatchStateHolder.pause()
        stopJob()
    }

    fun stop() {
        stopwatchStateHolder.stop()
        stopJob()
        clearValue()
    }

    private fun stopJob() {
        scope.coroutineContext.cancelChildren()
        job = null
    }

    private fun clearValue() {
        mutableTicker.value = "00:00:000"
    }

}