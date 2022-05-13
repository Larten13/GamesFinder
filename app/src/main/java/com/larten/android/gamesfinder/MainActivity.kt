package com.larten.android.gamesfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.RecyclerView
import com.larten.android.gamesfinder.data.MockDataGames
import com.larten.android.gamesfinder.data.MockDataGenres
import com.larten.android.gamesfinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAutoCompleteTextView: AutoCompleteTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mockDataGenres = MockDataGenres().loadGenres()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_genres)
        recyclerView.adapter = GenresAdapter(this, mockDataGenres)
        recyclerView.hasFixedSize()

        mAutoCompleteTextView = findViewById(R.id.search_bar)
        mAutoCompleteTextView.setAdapter(ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, MockDataGames().loadGames()))
    }
}