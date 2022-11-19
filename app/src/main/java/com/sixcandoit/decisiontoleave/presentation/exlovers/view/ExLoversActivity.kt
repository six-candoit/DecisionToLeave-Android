package com.sixcandoit.decisiontoleave.presentation.exlovers.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.sixcandoit.decisiontoleave.R
import com.sixcandoit.decisiontoleave.data.api.ResponseRepo
import com.sixcandoit.decisiontoleave.databinding.ActivityExloversBinding
import com.sixcandoit.decisiontoleave.presentation.exlovers.adapter.ExloversAdapter
import com.sixcandoit.decisiontoleave.presentation.exlovers.viewmodel.ExLoversViewModel

class ExLoversActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExloversBinding
    private val viewModel by viewModels<ExLoversViewModel>()
    private lateinit var adapter: ExloversAdapter

    override fun onCreate(savedInstanceState: Bundle?) { //뷰껍데기
        super.onCreate(savedInstanceState)
        binding = ActivityExloversBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
//        viewModel.exLovers.observe(this) {
//
//        }
    }

    private fun initAdapter() {
        adapter = ExloversAdapter(this)
        binding.rvHome.adapter = adapter
        initUserData()
    }

    private fun initUserData() {
        adapter.replaceList(
            listOf( //데이터 조작
                ResponseRepo("남규현", -21, "2020914","20221120"),
                ResponseRepo("류운호", 30, "20170414","20191120"),
                ResponseRepo("최현욱", -50, "20150213","20161225"),
            )
        )
    }
}
