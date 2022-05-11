package com.larten.android.gamesfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.larten.android.gamesfinder.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mockDataGenres = MockDataGenres().loadGenres()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_genres)
        recyclerView.adapter = GenresAdapter(this, mockDataGenres)
        recyclerView.hasFixedSize()
    }
}