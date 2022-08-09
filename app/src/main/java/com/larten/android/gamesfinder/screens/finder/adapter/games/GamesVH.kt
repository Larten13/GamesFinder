package com.larten.android.gamesfinder.screens.finder.adapter.games

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.larten.android.gamesfinder.R
import com.larten.android.gamesfinder.data.games.GameModel
import com.larten.android.gamesfinder.databinding.GameItemBinding

class GamesVH(
    private val binding: GameItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GameModel, listener: GamesAdapter.OnItemClickListener) {
        Glide.with(itemView.context)
            .load(item.backgroundImage)
            .placeholder(R.drawable.ic_baseline_videogame_asset_24)
            .centerCrop()
            .into(binding.posterOfGame)

        binding.apply {
            nameOfGame.text = item.name
            dateOfRelease.text = item.released
            genreOfGame.text = item.genres
            metaScore.text = item.metacritic.toString()
            root.setOnClickListener{listener.onGameClick(item.id)}
        }
    }
}