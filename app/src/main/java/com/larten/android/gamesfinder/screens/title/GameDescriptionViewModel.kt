package com.larten.android.gamesfinder.screens.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larten.android.gamesfinder.data.*
import com.larten.android.gamesfinder.retrofit.GamesRepository
import kotlinx.coroutines.launch

class GameDescriptionViewModel: ViewModel() {
    private val _gameLiveData = MutableLiveData<GameModel>()
    val gameLiveData: LiveData<GameModel> = _gameLiveData
    private val repository = GamesRepository()

    fun getGameInfo(id: Int) {
        viewModelScope.launch {
            val gameModel = repository.getGameInfo(id)
            _gameLiveData.value = refactorGameDescriptionModel(gameModel)
        }
    }
}