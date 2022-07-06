package com.larten.android.gamesfinder.retrofit

import com.larten.android.gamesfinder.data.GameDescriptionModel
import com.larten.android.gamesfinder.data.GameModelRetrofit
import com.larten.android.gamesfinder.data.PageGamesModelRetrofit
import retrofit2.http.GET
import retrofit2.http.Path

private const val KEY = "?key=517aba460acc4da0873a59a496d76e75"

interface ApiService {
    @GET("games$KEY")
    suspend fun getGames(): PageGamesModelRetrofit

    @GET("games/{id}$KEY")
    suspend fun getGameInfo(@Path("id") id: Int): GameDescriptionModel
}