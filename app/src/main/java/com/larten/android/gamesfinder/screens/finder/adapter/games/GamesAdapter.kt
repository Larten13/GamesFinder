package com.larten.android.gamesfinder.screens.finder.adapter.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.larten.android.gamesfinder.data.games.GameModel
import com.larten.android.gamesfinder.databinding.GameItemBinding

class GamesAdapter(
    private val listener: OnItemClickListener
): RecyclerView.Adapter<GamesVH>() {

    private var listGames = emptyList<GameModel>()

    interface OnItemClickListener {
        fun onGameClick(gameId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GameItemBinding.inflate(inflater, parent, false)
        return GamesVH(binding)
    }

    override fun onBindViewHolder(holder: GamesVH, position: Int) {
        holder.bind(listGames[position], listener)
    }

    override fun getItemCount(): Int {
        return listGames.size
    }

    fun setList(list: List<GameModel>) {
        listGames = list
        notifyDataSetChanged()
    }
}