package com.sixcandoit.decisiontoleave.presentation.decision.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sixcandoit.decisiontoleave.databinding.ActivityDecisionBinding
import com.sixcandoit.decisiontoleave.presentation.decision.viewmodel.DecisionViewModel

class DecisionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDecisionBinding
    private val viewModel by viewModels<DecisionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDecisionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
    }
}