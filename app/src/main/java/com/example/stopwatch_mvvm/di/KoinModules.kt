package com.example.stopwatch_mvvm.di

import com.example.stopwatch_mvvm.data.ITimestampProvider
import com.example.stopwatch_mvvm.view.viewmodel.ITimestampMillisecondsFormatter
import com.example.stopwatch_mvvm.view.viewmodel.TimestampMillisecondsFormatter
import com.example.stopwatch_mvvm.view.viewmodel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainEngine = module {
    viewModel { MainActivityViewModel(get(),get()) }
    factory<IStopwatchStateHolder> { StopwatchStateHolder(get(),get(),get()) }
    factory<IStopwatchStateCalculator> { StopwatchStateCalculator(get(),get()) }
    factory<ITimestampMillisecondsFormatter> { TimestampMillisecondsFormatter()  }
    single<ITimestampProvider> { TimestampProvider }
    single { ViewModelScope }
    factory<IElapsedTimeCalculator> { ElapsedTimeCalculator(get()) }
}

