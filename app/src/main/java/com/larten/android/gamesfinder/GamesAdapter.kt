package com.larten.android.gamesfinder

import android.net.wifi.p2p.WifiP2pManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.databinding.RecyclerViewItemBinding

interface ActionListener {
    fun onGameDetails(game: GameModel)
}

class GamesAdapter(
    private val actionListener: ActionListener
): RecyclerView.Adapter<GamesViewHolder>(), View.OnClickListener {

    private var listGames = emptyList<GameModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener(this)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val game = listGames[position]
        holder.bind(game)
        holder.itemView.tag = game
    }

    override fun getItemCount(): Int {
        return listGames.size
    }

    fun setList(list: List<GameModel>) {
        listGames = list
        notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        val game = v.tag as GameModel
        actionListener.onGameDetails(game)
    }
}