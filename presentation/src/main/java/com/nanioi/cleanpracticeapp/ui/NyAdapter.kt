package com.nanioi.cleanpracticeapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanioi.cleanpracticeapp.databinding.Top3ItemViewBinding
import com.nanioi.domain.ProfileMenuWatchTimeData

class NyAdapter : RecyclerView.Adapter<NyAdapter.ItemViewHolder>(){

    private var top3List : List<ProfileMenuWatchTimeData.WatchTimeTopData> = listOf()

    inner class ItemViewHolder(
        private val binding: Top3ItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bindData(data: ProfileMenuWatchTimeData.WatchTimeTopData,position : Int) = with(binding) {
            item = data
            ranking.text = "${position+1}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = Top3ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(top3List[position],position)
    }

    override fun getItemCount(): Int = top3List.size

    fun setTop3List(top3List : List<ProfileMenuWatchTimeData.WatchTimeTopData>){
        this.top3List = top3List
        notifyDataSetChanged()
    }
}