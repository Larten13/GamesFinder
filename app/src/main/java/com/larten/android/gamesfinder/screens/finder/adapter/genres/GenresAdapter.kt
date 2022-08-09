package com.larten.android.gamesfinder.screens.finder.adapter.genres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.larten.android.gamesfinder.data.genres.GenresModel
import com.larten.android.gamesfinder.databinding.GenreItemBinding

class GenresAdapter(
    val listener: OnItemClickListener
): RecyclerView.Adapter<GenresVH>() {

    private var genresList = emptyList<GenresModel>()

    interface OnItemClickListener {
        fun onGenreClick(genreId: Int) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GenreItemBinding.inflate(inflater, parent, false)
        return GenresVH(binding)
    }

    override fun onBindViewHolder(holder: GenresVH, position: Int) {
        holder.bind(genresList[position], listener)
    }

    override fun getItemCount(): Int = genresList.size

    fun setGenresList(list: List<GenresModel>) {
        genresList = list
    }
}