package com.larten.android.gamesfinder.screens.finder

import androidx.lifecycle.*
import com.larten.android.gamesfinder.data.*
import com.larten.android.gamesfinder.retrofit.GamesRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class FinderViewModel: ViewModel() {
    private val _pageLiveData = MutableLiveData<PageGamesModel>()
    val pageLiveData: LiveData<PageGamesModel> = _pageLiveData
    private val repository = GamesRepository()

    fun getGames() {
        viewModelScope.launch {
            val pageGamesModel = repository.getGames()
            val refactorPageGamesModel = refactorPageGamesModel(pageGamesModel)
            _pageLiveData.value = refactorPageGamesModel
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            _pageLiveData.value = refactorPageGamesModel(repository.search(query))
        }
    }

    private fun refactorPageGamesModel(pageGamesModelRetrofit: PageGamesModelRetrofit): PageGamesModel {
        return PageGamesModel(
            count = pageGamesModelRetrofit.count,
            next = pageGamesModelRetrofit.next,
            previous = pageGamesModelRetrofit.previous,
            results = refactorListGamesModel(pageGamesModelRetrofit.results)
        )
    }

    private fun refactorListGamesModel(listGameModelRetrofit: List<GameModelRetrofit>): List<GameModel> {
        return listGameModelRetrofit.map { gameModelRetrofit ->
            refactorGameModelRetrofit(gameModelRetrofit)
        }
    }
}