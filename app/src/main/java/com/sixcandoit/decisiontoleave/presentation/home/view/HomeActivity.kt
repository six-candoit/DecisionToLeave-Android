package com.sixcandoit.decisiontoleave.presentation.home.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sixcandoit.decisiontoleave.R
import com.sixcandoit.decisiontoleave.databinding.ActivityHomeBinding
import com.sixcandoit.decisiontoleave.presentation.decision.view.DecisionActivity
import com.sixcandoit.decisiontoleave.presentation.exlovers.view.ExLoversActivity
import com.sixcandoit.decisiontoleave.presentation.home.viewmodel.HomeViewModel
import com.sixcandoit.decisiontoleave.presentation.lover.view.LoverActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getUser()

        viewModel.homeResult.observe(this) {
            binding.tvCurrentNameHome.text = it.data.name
            Log.d("SSS", it.data.currentName)
            binding.progressbarHome.incrementProgressBy(it.data.percent)
            if (it.data.percent in 0..24) {
                binding.ivHome.setImageResource(R.drawable.ic_level1_home)
            } else if (it.data.percent in 25..49) {
                binding.ivHome.setImageResource(R.drawable.ic_level2_home)
            } else if (it.data.percent in 50..74) {
                binding.ivHome.setImageResource(R.drawable.ic_level3_home)
            } else {
                binding.ivHome.setImageResource(R.drawable.ic_level4_home)
            }
        }

        binding.imgbtnDecisionHome.setOnClickListener {
            val intent = Intent(this@HomeActivity, DecisionActivity::class.java)
            startActivity(intent)
        }

        binding.ivGoodbtnHome.setOnClickListener {
            val intent = Intent(this, LoverActivity::class.java)
            intent.putExtra("type", "1")
            startActivity(intent)
        }

        binding.ivBadbtnHome.setOnClickListener {
            val intent = Intent(this, LoverActivity::class.java)
            intent.putExtra("type", "0")
            startActivity(intent)
        }

        binding.ivUserHome.setOnClickListener {
            val intent = Intent(this@HomeActivity, ExLoversActivity::class.java)
            startActivity(intent)
        }
    }
}