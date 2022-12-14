package com.example.kitsu.ui.adapters.anime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.bumptech.glide.Glide
import com.example.kitsu.base.BaseDiffUtilItemCallback
import com.example.kitsu.databinding.ItemAnimeListBinding
import com.example.kitsu.models.kitsu.KitsuModel

class AnimeAdapter :
    PagingDataAdapter<KitsuModel, AnimeAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemAnimeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: KitsuModel?) {
            binding.tvAnimeTitle.text = item?.attributes?.titles?.ja_jp.toString()
            Glide
                .with(binding.ivPosterImage)
                .load(item?.attributes?.posterImage?.large)
                .into(binding.ivPosterImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimeListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}


