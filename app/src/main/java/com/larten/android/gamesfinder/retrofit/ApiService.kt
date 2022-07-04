package com.larten.android.gamesfinder.retrofit

import com.larten.android.gamesfinder.data.GameModelRetrofit
import com.larten.android.gamesfinder.data.PageGamesModelRetrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("games?key=517aba460acc4da0873a59a496d76e75")
    suspend fun getGames(): PageGamesModelRetrofit

    @GET("games/{id}")
    suspend fun getGameInfo(@Path("id") id: Int): GameModelRetrofit

}