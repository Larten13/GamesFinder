package com.larten.android.gamesfinder.data

import com.larten.android.gamesfinder.data.games.GenreModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameDescriptionModel(
    @Json(name = "background_image")
    val backgroundImage: String?,
    var genres: List<GenreModel>,
    val id: Int,
    val metacritic: Int?,
    val name: String,
    val released: String?,
    @Json(name = "description_raw")
    val description: String
)