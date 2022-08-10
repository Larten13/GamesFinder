package com.larten.android.gamesfinder.screens.finder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larten.android.gamesfinder.data.games.PageGamesModel
import com.larten.android.gamesfinder.retrofit.GamesRepository
import kotlinx.coroutines.launch
import java.util.*

class FinderViewModel: ViewModel() {
    private val _liveData = MutableLiveData<PageGamesModel>()
    val liveData: LiveData<PageGamesModel> = _liveData
    private val repository = GamesRepository()

    fun search(query: String) {
        viewModelScope.launch {
            _liveData.value = repository.search(query)
        }
    }

    fun getGamesOfGenres(genre: String) {
        viewModelScope.launch {
            _liveData.value = repository.getGamesOfGenres(genre)
        }
    }
}