package com.sixcandoit.decisiontoleave.presentation.lover.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.sixcandoit.decisiontoleave.databinding.ItemInputReportBinding
import com.sixcandoit.decisiontoleave.databinding.ItemReportBinding
import com.sixcandoit.decisiontoleave.presentation.lover.OnLoverItemClickListener

class LoverAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val questionList = mutableListOf<String?>()
    private lateinit var inflater: LayoutInflater
    private lateinit var onLoverItemClickListener: OnLoverItemClickListener

    fun setOnLoverItemClickListener(onLoverItemClickListener: OnLoverItemClickListener) {
        this.onLoverItemClickListener = onLoverItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        return when (viewType) {
            VIEW_TYPE_EDIT -> EditQuestionViewHolder(
                ItemInputReportBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            VIEW_TYPE_TEXT -> TextQuestionViewHolder(
                ItemReportBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Not found.")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EditQuestionViewHolder -> holder.bind()
            is TextQuestionViewHolder -> holder.bind(questionList[position]!!)
        }
    }

    override fun getItemCount(): Int = questionList.size

    override fun getItemViewType(position: Int): Int {
        return when {
            questionList[position].isNullOrEmpty() -> VIEW_TYPE_EDIT
            else -> VIEW_TYPE_TEXT
        }
    }

    fun submitQuestionList(questionList: List<String>) {
        this.questionList.add(null)
        this.questionList.addAll(questionList)
        notifyDataSetChanged()
    }

    inner class EditQuestionViewHolder(private val binding: ItemInputReportBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.etInputReport.addTextChangedListener {
                onLoverItemClickListener.onTextChange(binding.etInputReport.text.toString())
            }
        }
    }

    inner class TextQuestionViewHolder(private val binding: ItemReportBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: String) {
            binding.tvReport.text = question
            binding.tvReport.setOnClickListener {
                onLoverItemClickListener.onClickItem(binding.tvReport.text.toString())
                binding.tvReport.setTextColor(Color.parseColor("#F2EEE3"))
            }
        }
    }

    companion object {
        private const val VIEW_TYPE_EDIT = 0
        private const val VIEW_TYPE_TEXT = 1
    }
}