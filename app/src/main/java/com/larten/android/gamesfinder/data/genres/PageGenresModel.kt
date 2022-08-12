package com.larten.android.gamesfinder.data.genres

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PageGenresModel(
    val next: String?,
    val previous: String?,
    val results: List<GenresModel>
)

@JsonClass(generateAdapter = true)
data class GenresModel(
    val id: Int,
    val name: String,
    val slug: String,
    @Json(name = "games_count")
    val gamesCount: Int,
    @Json(name = "image_background")
    val imageBackground: String
)