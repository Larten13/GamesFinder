package com.larten.android.gamesfinder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.databinding.RecyclerViewItemBinding

class GamesViewHolder(
    private val binding: RecyclerViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GameModel, listener: GamesAdapter.OnItemClickListener) {
        binding.root.setOnClickListener{listener.onItemClick(item.id)}
        Glide.with(itemView.context)
            .load(item.backgroundImage)
            .placeholder(R.drawable.ic_baseline_videogame_asset_24)
            .centerCrop()
            .into(binding.posterOfGame)
        binding.nameOfGame.text = item.name
        binding.dateOfRelease.text = item.released
        binding.genreOfGame.text = item.genres
        binding.metaScore.text = item.metacritic.toString()
    }
}