package com.larten.android.gamesfinder.data.games

import com.squareup.moshi.JsonClass

data class PageGamesModel(
    val count: Int,
    val next: String?,
    val previous: Any?,
    val results: List<GameModel>
)

data class GameModel(
    val backgroundImage: String,
    var genres: String,
    val id: Int,
    val metacritic: Int?,
    val name: String,
    val released: String,
    val description: String,
)

@JsonClass(generateAdapter = true)
data class GenreModel(
    val id: Int,
    val name: String
)