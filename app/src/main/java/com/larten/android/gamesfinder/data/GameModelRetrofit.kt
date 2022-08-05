package com.larten.android.gamesfinder.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameModelRetrofit(
    @Json(name = "background_image")
    val backgroundImage: String?,
    var genres: List<GenreModel>,
    val id: Int,
    val metacritic: Int?,
    val name: String,
    val released: String?
)

fun refactorGameModelRetrofit(gameModelRetrofit: GameModelRetrofit): GameModel {
    return GameModel(
        id = gameModelRetrofit.id,
        backgroundImage = gameModelRetrofit.backgroundImage ?: "No background image",
        genres = gameModelRetrofit.genres.joinToString(",", "", "", -1, "") { it.name },
        metacritic = gameModelRetrofit.metacritic ?: 0,
        name = gameModelRetrofit.name,
        released = gameModelRetrofit.released ?: "No release date",
        description = ""
    )
}
