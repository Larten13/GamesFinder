package com.larten.android.gamesfinder.data

data class GameModel(
    val backgroundImage: String,
    var genres: String,
    val id: Int,
    val metacritic: Int?,
    val name: String,
    val released: String,
    val description: String,
)