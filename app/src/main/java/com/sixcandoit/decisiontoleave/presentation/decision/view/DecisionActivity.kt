package com.sixcandoit.decisiontoleave.presentation.decision.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sixcandoit.decisiontoleave.R
import com.sixcandoit.decisiontoleave.databinding.ActivityDecisionBinding
import com.sixcandoit.decisiontoleave.presentation.decision.viewmodel.DecisionViewModel
import com.sixcandoit.decisiontoleave.presentation.exlovers.view.ExLoversActivity
import com.sixcandoit.decisiontoleave.presentation.home.view.HomeActivity

class DecisionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDecisionBinding
    private val viewModel by viewModels<DecisionViewModel>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDecisionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        viewModel.getReport()
        viewModel.goodbye()

        viewModel.reportResult.observe(this) {
            if (it.data.good >= 0)
                binding.tvGoodPointDecision.text = "+" + it.data.good.toString()
            else
                binding.tvGoodPointDecision.text = it.data.good.toString()
            if (it.data.bad >= 0)
                binding.tvBadPointDecision.text = "+" + it.data.bad.toString()
            else binding.tvBadPointDecision.text = it.data.bad.toString()
            binding.tvSumPointDecision.text = (it.data.good + it.data.bad).toString()
            binding.tvDecideNameDecision.text = it.data.currentName
            if (it.data.percent <= 24) {
                binding.ivProfileDecision.setImageResource(R.drawable.ic_lv1_decision)
            } else if (it.data.percent in 25..49) {
                binding.ivProfileDecision.setImageResource(R.drawable.ic_lv2_decision)
            } else if (it.data.percent in 50..74) {
                binding.ivProfileDecision.setImageResource(R.drawable.ic_lv3_decision)
            } else {
                binding.ivProfileDecision.setImageResource(R.drawable.ic_lv4_decision)
            }
        }

        binding.btnMaintainDecision.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnEndDecision.setOnClickListener {
            //viewModel.goodbye()
            val intent = Intent(this, ExLoversActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}