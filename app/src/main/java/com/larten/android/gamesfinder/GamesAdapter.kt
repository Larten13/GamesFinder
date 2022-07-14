package com.larten.android.gamesfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.databinding.RecyclerViewItemBinding

class GamesAdapter(
    private val mListener: OnItemClickListener
): RecyclerView.Adapter<GamesViewHolder>() {

    private var listGames = emptyList<GameModel>()

    interface OnItemClickListener {
        fun onItemClick(gameId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(inflater, parent, false)
        return GamesViewHolder(binding, mListener)
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