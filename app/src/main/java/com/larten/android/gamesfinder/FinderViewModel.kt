package com.larten.android.gamesfinder

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.data.GameModelRetrofit
import com.larten.android.gamesfinder.data.PageGamesModel
import com.larten.android.gamesfinder.data.PageGamesModelRetrofit
import com.larten.android.gamesfinder.retrofit.RetrofitRepo
import kotlinx.coroutines.launch

class FinderViewModel: ViewModel() {
    val pageLiveData: MutableLiveData<PageGamesModel> = MutableLiveData()
    private lateinit var refactorPageGamesModel: PageGamesModel
    private val repository = RetrofitRepo()

    fun getGames() {
        viewModelScope.launch {
            val pageGamesModel = repository.getGames()
            refactorPageGamesModel = refactorPageGamesModel(pageGamesModel)
            pageLiveData.value = refactorPageGamesModel
        }
    }

    private fun refactorPageGamesModel(pageGamesModelRetrofit: PageGamesModelRetrofit): PageGamesModel {
        val pageGamesModel: PageGamesModel?
        pageGamesModel = PageGamesModel(
            count = pageGamesModelRetrofit.count,
            description = pageGamesModelRetrofit.description,
            next = pageGamesModelRetrofit.next,
            previous = pageGamesModelRetrofit.previous,
            results = refactorListGamesModel(pageGamesModelRetrofit.results)
        )
        return pageGamesModel
    }

        private fun refactorListGamesModel(listGameModelRetrofit: List<GameModelRetrofit>): List<GameModel> {
        val listGameModel: MutableList<GameModel> = ArrayList()
        listGameModelRetrofit.forEach { gameModelRetrofit ->
            val gameModel = GameModel(
                backgroundImage = gameModelRetrofit.backgroundImage,
                genres = gameModelRetrofit.genres.joinToString(",", "", "", -1, "") { it.name },
                id = gameModelRetrofit.id,
                metacritic = gameModelRetrofit.metacritic,
                name = gameModelRetrofit.name,
                released = gameModelRetrofit.released,
                slug = gameModelRetrofit.slug
            )
            listGameModel.add(gameModel)
        }
        return listGameModel
    }
}