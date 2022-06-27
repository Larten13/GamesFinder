package com.larten.android.gamesfinder.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenreModel(
    @Json(name = "games_count")
    val gamesCount: Int,
    @Json(name = "image_background")
    val imageBackground: String,
    val id: Int,
    val name: String,
    val slug: String
)