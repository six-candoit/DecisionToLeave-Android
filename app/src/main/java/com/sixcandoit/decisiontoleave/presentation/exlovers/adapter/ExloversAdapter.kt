package com.sixcandoit.decisiontoleave.presentation.exlovers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sixcandoit.decisiontoleave.data.api.ResponseRepo
import com.sixcandoit.decisiontoleave.databinding.ItemListExloversBinding

class ExloversAdapter(context: Context) : RecyclerView.Adapter<ExloversAdapter.BodyViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var list: List<ResponseRepo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodyViewHolder {
        val binding = ItemListExloversBinding.inflate(inflater, parent, false)
        return BodyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BodyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun replaceList(newList: List<ResponseRepo>) {
        list = newList.toList()
        notifyDataSetChanged()
    }

    class BodyViewHolder(
        private val binding: ItemListExloversBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(follower: ResponseRepo) {
            binding.tvName.text = "${follower.name}님과의 연애"
            binding.tvTotal.text = "Total    |    ${follower.score}"
            binding.tvDate.text = "${follower.start}_${follower.end}"
        }
    }
}