package com.larten.android.gamesfinder.retrofit

import android.util.Log
import com.larten.android.gamesfinder.data.GameDescriptionModel
import com.larten.android.gamesfinder.data.PageGamesModelRetrofit
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

class GamesRepository {
    suspend fun getGames(): PageGamesModelRetrofit {
        return RetrofitInstance.api.getGames()
    }

    suspend fun getGameInfo(id: Int): GameDescriptionModel {
        return RetrofitInstance.api.getGameInfo(id)
    }

    suspend fun search(query: String?): PageGamesModelRetrofit {
        Log.d("Repo", "запрос к апи")
        return RetrofitInstance.api.search(query)
    }
}