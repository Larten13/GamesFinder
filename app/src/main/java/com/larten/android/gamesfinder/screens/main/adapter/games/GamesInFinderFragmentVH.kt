package com.larten.android.gamesfinder.screens.main.adapter.games

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.larten.android.gamesfinder.R
import com.larten.android.gamesfinder.data.games.GameModel
import com.larten.android.gamesfinder.databinding.GameFinderItemBinding
import com.larten.android.gamesfinder.databinding.GameItemBinding

class GamesInFinderFragmentVH(
    private val binding: GameFinderItemBinding,
    private val listener: GamesAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

//    private val binding: GameItemBinding
//    ): RecyclerView.ViewHolder(itemView) {

//    fun bind(item: GameModel, listener: GamesAdapter.OnItemClickListener) {
//        Glide.with(itemView.context)
//            .load(item.backgroundImage)
//            .placeholder(R.drawable.ic_baseline_videogame_asset_24)
//            .centerCrop()
//            .into(binding.posterOfGame)
//
//        binding.apply {
//            nameOfGame.text = item.name
//            dateOfRelease.text = item.released
//            genreOfGame.text = item.genres
//            metaScore.text = item.metacritic.toString()
//            root.setOnClickListener{listener.onItemClick(item.id)}
//        }
//    }

    fun bind(item: GameModel) {
        Glide.with(itemView.context)
            .load(item.backgroundImage)
            .placeholder(R.drawable.ic_baseline_videogame_asset_24)
            .centerCrop()
            .into(binding.posterOfGame)
        binding.apply {
            nameOfGameInFinder.text = item.name
            dateOfReleaseInFinder.text = item.released
            genreOfGameInFinder.text = item.genres
            root.setOnClickListener{listener.onItemClick(item.id)}
        }
    }
}

class GamesInMainFragmentVH(
    private val binding: GameItemBinding,
    private val listener: GamesAdapter.OnItemClickListener
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GameModel) {
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
            root.setOnClickListener{listener.onItemClick(item.id)}

        }
    }
}