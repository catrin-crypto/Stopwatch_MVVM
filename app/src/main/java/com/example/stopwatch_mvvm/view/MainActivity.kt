package com.example.stopwatch_mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.stopwatch_mvvm.R
import com.example.stopwatch_mvvm.databinding.ActivityMainBinding
import com.example.stopwatch_mvvm.view.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}