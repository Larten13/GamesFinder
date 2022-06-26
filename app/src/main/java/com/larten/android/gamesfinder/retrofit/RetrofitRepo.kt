package com.larten.android.gamesfinder.retrofit

import com.larten.android.gamesfinder.data.PageGamesModel
import retrofit2.Response

class RetrofitRepo {
    suspend fun getGames(): Response<PageGamesModel> {
        return RetrofitInstance.api.getGames()
    }
}