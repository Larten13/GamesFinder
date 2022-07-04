package com.larten.android.gamesfinder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.databinding.RecyclerViewItemBinding

class GamesViewHolder(private val binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(game: GameModel) {
        Glide.with(itemView.context)
            .load(game.backgroundImage)
            .placeholder(R.drawable.ic_baseline_videogame_asset_24)
            .centerCrop()
            .into(binding.posterOfGame)
        binding.nameOfGame.text = game.name
        binding.dateOfRelease.text = game.released
        binding.genreOfGame.text = game.genres
    }
}