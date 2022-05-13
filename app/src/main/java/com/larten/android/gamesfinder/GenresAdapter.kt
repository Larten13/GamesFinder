package com.larten.android.gamesfinder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.larten.android.gamesfinder.data.Genre
import com.larten.android.gamesfinder.databinding.RecyclerViewItemBinding

class GenresAdapter(
    private val context: Context,
    private val dataset: List<Genre>
) : RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {

    class GenresViewHolder(binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val textView: TextView = binding.nameOfGenre
        private var imageView: ImageView = binding.posterOfGenre

        fun bind(genre: Genre) {
            val glide = Glide.with(itemView.context)
                .load(genre.imageBackground)
                .placeholder(R.drawable.ic_baseline_videogame_asset_24)
                .into(imageView)
            textView.text = genre.name
            imageView = glide.view
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(inflater, parent, false)
        return GenresViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}