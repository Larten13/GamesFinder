package com.larten.android.gamesfinder.screens.finder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larten.android.gamesfinder.data.*
import com.larten.android.gamesfinder.retrofit.GamesRepository
import kotlinx.coroutines.launch

class FinderViewModel: ViewModel() {
    private val _pageLiveData = MutableLiveData<PageGamesModel>()
    val pageLiveData: LiveData<PageGamesModel> = _pageLiveData
    private lateinit var refactorPageGamesModel: PageGamesModel
    private val repository = GamesRepository()

    fun getGames() {
        viewModelScope.launch {
            val pageGamesModel = repository.getGames()
            refactorPageGamesModel = refactorPageGamesModel(pageGamesModel)
            _pageLiveData.value = refactorPageGamesModel
        }
    }

    private fun refactorPageGamesModel(pageGamesModelRetrofit: PageGamesModelRetrofit): PageGamesModel {
        return PageGamesModel(
            count = pageGamesModelRetrofit.count,
            description = pageGamesModelRetrofit.description,
            next = pageGamesModelRetrofit.next,
            previous = pageGamesModelRetrofit.previous,
            results = refactorListGamesModel(pageGamesModelRetrofit.results)
        )
    }

    private fun refactorListGamesModel(listGameModelRetrofit: List<GameModelRetrofit>): List<GameModel> {
        return listGameModelRetrofit.map { gameModelRetrofit ->
            refactorGameModel(gameModelRetrofit)
        }
    }
}