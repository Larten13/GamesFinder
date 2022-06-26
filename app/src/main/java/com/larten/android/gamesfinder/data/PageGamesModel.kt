package com.larten.android.gamesfinder.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PageGamesModel(
    val count: Int,
    val description: String,
    val next: String,
    val previous: Any?,
    val results: List<GameModel>,
)