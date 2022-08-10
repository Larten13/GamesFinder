package com.larten.android.gamesfinder.retrofit

import com.larten.android.gamesfinder.data.GameDescriptionModel
import com.larten.android.gamesfinder.data.PageGamesModelRetrofit
import com.larten.android.gamesfinder.data.genres.PageGenresModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val KEY = "?key=517aba460acc4da0873a59a496d76e75"

interface ApiService {
    @GET("games$KEY")
    suspend fun getGames(): PageGamesModelRetrofit

    @GET("genres$KEY")
    suspend fun getGenres(): PageGenresModel

    @GET("games$KEY")
    suspend fun getGamesOfGenres(@Query("genres") genre: String): PageGamesModelRetrofit

    @GET("games/{id}$KEY")
    suspend fun getGameInfo(@Path("id") id: Int): GameDescriptionModel

    @GET("games$KEY")
    suspend fun search(@Query("search") query: String?): PageGamesModelRetrofit
}