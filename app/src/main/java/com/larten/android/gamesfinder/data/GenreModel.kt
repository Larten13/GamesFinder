package com.larten.android.gamesfinder.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenreModel(
    val games_count: Int,
    val id: Int,
    val image_background: String,
    val name: String,
    val slug: String
)