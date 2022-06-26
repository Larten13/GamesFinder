package com.larten.android.gamesfinder.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameModel(
    val background_image: String,
    val genres: List<GenreModel>,
    val id: Int,
    val metacritic: Int,
    val name: String,
    val released: String,
    val slug: String,
)