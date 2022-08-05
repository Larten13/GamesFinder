package com.larten.android.gamesfinder.screens.finder

import android.app.appsearch.SearchResult
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.Transformations.switchMap
import com.larten.android.gamesfinder.data.*
import com.larten.android.gamesfinder.retrofit.GamesRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class FinderViewModel: ViewModel() {
    private val _pageLiveData = MutableLiveData<PageGamesModel>()
    val pageLiveData: LiveData<PageGamesModel> = _pageLiveData
    private val repository = GamesRepository()

    val searchFlow = MutableSharedFlow<String?>(1)

    fun getGames() {
        viewModelScope.launch {
            val pageGamesModel = repository.getGames()
            val refactorPageGamesModel = refactorPageGamesModel(pageGamesModel)
            _pageLiveData.value = refactorPageGamesModel
        }
    }

    suspend fun search(queryFlow: Flow<String?>): Flow<PageGamesModel> {
        return queryFlow.mapLatest {
            refactorPageGamesModel(repository.search(it))
        }.debounce(500)
    }

    suspend fun setQuery(query: String?) {
        Log.d("ViewModel", "Search is launch")
        searchFlow.emit(query)
        delay(510)
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
//        return flow {
//            emit(refactorPageGamesModel(repository.search(query)))
//        }.stateIn(viewModelScope)