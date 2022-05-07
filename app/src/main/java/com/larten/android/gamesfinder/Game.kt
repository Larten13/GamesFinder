package com.larten.android.gamesfinder

data class Game (
val id: Int,
val name: String,
val developer: String,
val dateOfRelease: String,
val metaScore: Int,
val gamersScore: Double,
val genre: String,
val platform: Platforms
        )