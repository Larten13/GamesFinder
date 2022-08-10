package com.larten.android.gamesfinder.screens.main.adapter.genres

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.larten.android.gamesfinder.R
import com.larten.android.gamesfinder.data.genres.GenresModel
import com.larten.android.gamesfinder.databinding.GenreItemBinding

class GenresVH(
    private val binding: GenreItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GenresModel, listener: GenresAdapter.OnItemClickListener) {
            Glide.with(itemView.context)
                .load(item.imageBackground)
                .placeholder(R.drawable.ic_baseline_videogame_asset_24)
                .centerCrop()
                .into(binding.posterOfGenre)

            binding.apply {
                nameOfGenre.text = item.name
                countOfGames.text = item.gamesCount.toString()
                root.setOnClickListener {listener.onGenreClick(item.slug)}
            }
        }

}