package com.larten.android.gamesfinder.data

data class Game (
        val id: Int,
        val name: String,
        val slug: String,
        val released: String,
        val metaCritic: Int,
        val genre: Genre,
        val platform: Platform
)