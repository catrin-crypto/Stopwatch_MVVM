package com.example.stopwatch_mvvm.view.viewmodel

interface ITimestampMillisecondsFormatter {
    fun format(timestamp: Long): String
    fun Long.pad(desiredLength: Int): String
}