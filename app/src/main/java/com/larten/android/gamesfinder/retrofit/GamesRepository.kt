package com.larten.android.gamesfinder.retrofit

import com.larten.android.gamesfinder.data.GameDescriptionModel
import com.larten.android.gamesfinder.data.PageGamesModelRetrofit

class GamesRepository {
    suspend fun getGames(): PageGamesModelRetrofit {
        return RetrofitInstance.api.getGames()
    }

    suspend fun getGameInfo(id: Int): GameDescriptionModel {
        return RetrofitInstance.api.getGameInfo(id)
    }

    suspend fun search(query: String?): PageGamesModelRetrofit {
        return RetrofitInstance.api.search(query)
    }
}