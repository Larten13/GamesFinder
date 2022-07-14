package com.larten.android.gamesfinder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.databinding.RecyclerViewItemBinding

class GamesViewHolder(
    private val binding: RecyclerViewItemBinding,
    private val listener: GamesAdapter.OnItemClickListener
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private lateinit var game: GameModel

    init {
        binding.root.setOnClickListener(this)
    }

    fun bind(item: GameModel) {
        game = item
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

    override fun onClick(v: View) {
        listener.onItemClick(game.id)
    }
}