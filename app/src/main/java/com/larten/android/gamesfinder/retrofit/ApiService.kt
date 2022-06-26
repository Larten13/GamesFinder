package com.larten.android.gamesfinder.retrofit

import com.larten.android.gamesfinder.data.PageGamesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("games?key=517aba460acc4da0873a59a496d76e75")
    suspend fun getGames(): Response<PageGamesModel>
}