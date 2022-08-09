package com.larten.android.gamesfinder.retrofit

import android.util.Log
import com.larten.android.gamesfinder.data.GameDescriptionModel
import com.larten.android.gamesfinder.data.GameModelRetrofit
import com.larten.android.gamesfinder.data.PageGamesModelRetrofit
import com.larten.android.gamesfinder.data.games.GameModel
import com.larten.android.gamesfinder.data.games.PageGamesModel
import com.larten.android.gamesfinder.data.genres.PageGenresModel

class GamesRepository {
    suspend fun getGames(): PageGamesModel {
        return refactorPageGamesModel(RetrofitInstance.api.getGames())
    }

    suspend fun getGenres(): PageGenresModel {
        return RetrofitInstance.api.getGenres()
    }

    suspend fun getGameInfo(id: Int): GameModel {
        return refactorGameDescriptionModel(RetrofitInstance.api.getGameInfo(id))
    }

    suspend fun search(query: String?): PageGamesModel {
        Log.d("Repo", "запрос к апи")
        return refactorPageGamesModel(RetrofitInstance.api.search(query))
    }

    private fun refactorPageGamesModel(pageGamesModelRetrofit: PageGamesModelRetrofit) = PageGamesModel(
        count = pageGamesModelRetrofit.count,
        next = pageGamesModelRetrofit.next,
        previous = pageGamesModelRetrofit.previous,
        results = pageGamesModelRetrofit.results.map { gameModelRetrofit ->
            refactorGameModelRetrofit(gameModelRetrofit)
        }
    )

    private fun refactorGameModelRetrofit(gameModelRetrofit: GameModelRetrofit) = GameModel(
        id = gameModelRetrofit.id,
        backgroundImage = gameModelRetrofit.backgroundImage ?: "No background image",
        genres = gameModelRetrofit.genres.joinToString(",", "", "", -1, "") { it.name },
        metacritic = gameModelRetrofit.metacritic ?: 0,
        name = gameModelRetrofit.name,
        released = gameModelRetrofit.released ?: "No release date",
        description = ""
    )

    private fun refactorGameDescriptionModel(gameDescriptionModel: GameDescriptionModel) = GameModel(
        id = gameDescriptionModel.id,
        backgroundImage = gameDescriptionModel.backgroundImage ?: "No background image",
        genres = gameDescriptionModel.genres.joinToString(",", "", "", -1, "") { it.name },
        metacritic = gameDescriptionModel.metacritic ?: 0,
        name = gameDescriptionModel.name,
        released = gameDescriptionModel.released ?: "No release data",
        description = gameDescriptionModel.description
    )
}