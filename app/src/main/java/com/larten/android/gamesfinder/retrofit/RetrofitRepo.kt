package com.larten.android.gamesfinder.retrofit

import com.larten.android.gamesfinder.data.PageGamesModelRetrofit

class RetrofitRepo {
    suspend fun getGames(): PageGamesModelRetrofit {
        return RetrofitInstance.api.getGames()
    }
}