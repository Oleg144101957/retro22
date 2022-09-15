package com.example.retro22

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retro22.databinding.HistoryItemBinding
import com.example.retro22.model.Numb

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    inner class HistoryViewHolder (val binding: HistoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var historyList = emptyList<Numb>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(HistoryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val number = historyList[position]

        holder.binding.apply {
            tvHistoryString.text = number.description
        }
    }

    override fun getItemCount() = historyList.size

    fun setList(list: List<Numb>){
        historyList = list
        notifyDataSetChanged()
    }
}