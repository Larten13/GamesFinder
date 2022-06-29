package com.larten.android.gamesfinder.data

data class PageGamesModel(
    val count: Int,
    val description: String,
    val next: String,
    val previous: Any?,
    val results: List<GameModel>
)