package com.example.stopwatch_mvvm.data

interface TimestampProvider {
    fun getMilliseconds(): Long
}