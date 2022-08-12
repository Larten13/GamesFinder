package com.larten.android.gamesfinder.screens.main.adapter.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.larten.android.gamesfinder.R
import com.larten.android.gamesfinder.data.games.GameModel
import com.larten.android.gamesfinder.databinding.GameFinderItemBinding
import com.larten.android.gamesfinder.databinding.GameItemBinding

class GamesAdapter(
    private val listener: OnItemClickListener,
    private val _viewType: Int
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listGames = emptyList<GameModel>()

    interface OnItemClickListener {
        fun onGameClick(gameId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (_viewType) {
            R.layout.game_finder_item -> {
                val binding = GameFinderItemBinding.inflate(inflater, parent, false)
                GamesInFinderFragmentVH(binding, listener)
            }
            else -> {
                val binding = GameItemBinding.inflate(inflater, parent, false)
                GamesInMainFragmentVH(binding,listener)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is GamesInFinderFragmentVH -> holder.bind(listGames[position])
            is GamesInMainFragmentVH -> holder.bind(listGames[position])
        }
    }

    override fun getItemCount(): Int {
        return listGames.size
    }

    fun setList(list: List<GameModel>) {
        listGames = list
        notifyDataSetChanged()
    }
}