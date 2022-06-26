package com.larten.android.gamesfinder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.data.GenreModel
import com.larten.android.gamesfinder.databinding.RecyclerViewItemBinding

class GamesAdapter: RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

    private var listGames = emptyList<GameModel>()

    class GamesViewHolder(binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val nameOfGame: TextView = binding.nameOfGame
        private var posterOfGame: ImageView = binding.posterOfGame
        private var dateOfRelease: TextView = binding.dateOfRelease
        private var genreOfGame: TextView = binding.genreOfGame


        fun bind(game: GameModel) {
            val glide = Glide.with(itemView.context)
                .load(game.background_image)
                .placeholder(R.drawable.ic_baseline_videogame_asset_24)
                .centerCrop()
                .into(posterOfGame)
            nameOfGame.text = game.name
            dateOfRelease.text = game.released
            genreOfGame.text = game.genres.joinToString(",","", "",-1, "") {it.name}
            posterOfGame = glide.view
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(inflater, parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(listGames[position])
    }

    override fun getItemCount(): Int {
        return listGames.size
    }


    fun setList(list: List<GameModel>) {
        listGames = list
        notifyDataSetChanged()
    }
}