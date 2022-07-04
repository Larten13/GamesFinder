package com.larten.android.gamesfinder.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PageGamesModelRetrofit(
    val count: Int,
    val description: String,
    val next: String,
    val previous: Any?,
    val results: List<GameModelRetrofit>
)