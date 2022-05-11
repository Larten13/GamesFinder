package com.larten.android.gamesfinder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GenresAdapter(
    private val context: Context,
    private val dataset: List<Genre>
) : RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {

    class GenresViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.name_of_genre)
        val imageView: ImageView = view.findViewById(R.id.poster_of_genre)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return GenresViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.name
        holder.imageView.setImageResource(item.imageBackground)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}