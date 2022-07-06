package com.larten.android.gamesfinder.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameDescriptionModel(
    @Json(name = "background_image")
    val backgroundImage: String,
    var genres: List<GenreModel>,
    val id: Int,
    val metacritic: Int,
    val name: String,
    val released: String,
    @Json(name = "description_raw")
    val description: String
)
    fun refactorGameDescriptionModel(gameDescriptionModel: GameDescriptionModel): GameModel {
        return GameModel(
            id = gameDescriptionModel.id,
            backgroundImage = gameDescriptionModel.backgroundImage,
            genres = gameDescriptionModel.genres.joinToString(",", "", "", -1, "") { it.name },
            metacritic = gameDescriptionModel.metacritic,
            name = gameDescriptionModel.name,
            released = gameDescriptionModel.released,
            description = gameDescriptionModel.description
        )
    }