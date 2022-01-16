package com.example.stopwatch_mvvm.view.viewmodel

object TimestampProvider :
    com.example.stopwatch_mvvm.data.ITimestampProvider {
    override fun getMilliseconds(): Long {
        return System.currentTimeMillis()
    }
}