package com.sixcandoit.decisiontoleave.presentation.lover.view

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.sixcandoit.decisiontoleave.R
import com.sixcandoit.decisiontoleave.data.model.RequestLoverReportDTO
import com.sixcandoit.decisiontoleave.databinding.ActivityLoverBinding
import com.sixcandoit.decisiontoleave.presentation.lover.ConfirmDialogFragment
import com.sixcandoit.decisiontoleave.presentation.lover.OnDialogClickListener
import com.sixcandoit.decisiontoleave.presentation.lover.OnLoverItemClickListener
import com.sixcandoit.decisiontoleave.presentation.lover.adapter.LoverAdapter
import com.sixcandoit.decisiontoleave.presentation.lover.viewmodel.LoverViewModel
import com.sixcandoit.decisiontoleave.util.EventObserver

class LoverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoverBinding
    private val viewModel by viewModels<LoverViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        initView()
        setAdapter()
        setObservers()
        setOnClickListener()
    }

    private fun initView() {
        val type = intent.getStringExtra("type")
        if (type != null) {
            binding.type = type
            viewModel.setType(type)
            viewModel.getQuestionList(type.toInt())
        } else {
            binding.type = "0"
            viewModel.setType("0")
            viewModel.getQuestionList(0)
        }
    }

    private fun setObservers() {
        viewModel.reportEvent.observe(
            this, EventObserver {
            }
        )
        viewModel.contentEvent.observe(
            this, EventObserver {
                if (it) {
                    binding.btnSaveLover.isEnabled = true
                    binding.btnSaveLover.backgroundTintList =
                        ColorStateList.valueOf(
                            ContextCompat.getColor(
                                this,
                                R.color.decision_to_leave_black
                            )
                        )
                }
            }
        )
    }

    private fun setOnClickListener() {
        binding.btnSaveLover.setOnClickListener {
            viewModel.setReport(
                RequestLoverReportDTO(
                    viewModel.getContent(),
                    (binding.sbFavorLover.progress / 25) + 1
                )
            )
            val confirmDialog = ConfirmDialogFragment(viewModel.getType())
            confirmDialog.setListener(object :
                OnDialogClickListener {

                override fun onSuccess() {
                    finish()
                }
            })
            confirmDialog.show(supportFragmentManager, "ConfirmDialog")
        }
    }

    private fun setAdapter() {
        val adapter = LoverAdapter()
        binding.rvLover.adapter = adapter
        adapter.setOnLoverItemClickListener(object : OnLoverItemClickListener {
            override fun onTextChange(text: String) {
                viewModel.setContent(text)
            }

            override fun onClickItem(text: String) {
                viewModel.setContent(text)
            }
        })
        viewModel.questionList.observe(
            this
        ) {
            adapter.submitQuestionList(it)
        }
    }
}