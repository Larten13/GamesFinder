package com.larten.android.gamesfinder.screens.main

import androidx.lifecycle.*
import com.larten.android.gamesfinder.data.games.PageGamesModel
import com.larten.android.gamesfinder.data.genres.PageGenresModel
import com.larten.android.gamesfinder.retrofit.GamesRepository
import kotlinx.coroutines.*

class MainViewModel: ViewModel() {
    private val _pageGamesLiveData = MutableLiveData<PageGamesModel>()
    private val _pageGenresLiveData = MutableLiveData<PageGenresModel>()
    val pageGamesLiveData: LiveData<PageGamesModel> = _pageGamesLiveData
    val pageGenresLiveData: LiveData<PageGenresModel> = _pageGenresLiveData
    private val repository = GamesRepository()

    init {
        viewModelScope.launch {
            _pageGenresLiveData.value = repository.getGenres()
            _pageGamesLiveData.value = repository.getGames()
        }
    }
}