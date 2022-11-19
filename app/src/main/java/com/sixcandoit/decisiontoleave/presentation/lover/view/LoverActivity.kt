package com.sixcandoit.decisiontoleave.presentation.lover.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sixcandoit.decisiontoleave.databinding.ActivityLoverBinding
import com.sixcandoit.decisiontoleave.presentation.lover.viewmodel.LoverViewModel

class LoverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoverBinding
    private val viewModel by viewModels<LoverViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
    }
}