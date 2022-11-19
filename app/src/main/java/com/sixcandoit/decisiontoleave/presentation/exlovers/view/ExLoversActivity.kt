package com.sixcandoit.decisiontoleave.presentation.exlovers.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sixcandoit.decisiontoleave.databinding.ActivityExloversBinding
import com.sixcandoit.decisiontoleave.presentation.exlovers.viewmodel.ExLoversViewModel

class ExLoversActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExloversBinding
    private val viewModel by viewModels<ExLoversViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExloversBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
    }
}