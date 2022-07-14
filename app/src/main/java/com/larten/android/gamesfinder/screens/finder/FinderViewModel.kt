package com.larten.android.gamesfinder.screens.finder

import android.util.Log
import androidx.lifecycle.*
import com.bumptech.glide.Glide.init
import com.larten.android.gamesfinder.data.*
import com.larten.android.gamesfinder.retrofit.GamesRepository
import kotlinx.coroutines.launch

class FinderViewModel: ViewModel() {
    private val _pageLiveData = MutableLiveData<PageGamesModel>()
    val pageLiveData: LiveData<PageGamesModel> = _pageLiveData
    private val repository = GamesRepository()

    init {
        viewModelScope.launch {
            val pageGamesModel = repository.getGames()
            val refactorPageGamesModel = refactorPageGamesModel(pageGamesModel)
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
            refactorGameModelRetrofit(gameModelRetrofit)
        }
    }
}