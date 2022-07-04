package com.larten.android.gamesfinder.screens.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.data.GameModelRetrofit
import com.larten.android.gamesfinder.retrofit.RetrofitRepo
import kotlinx.coroutines.launch

class TitleViewModel: ViewModel() {
    private val _gameLiveData = MutableLiveData<GameModel>()
    val gameLiveData: LiveData<GameModel> = _gameLiveData
    private val repository = RetrofitRepo()

    fun getGameInfo(id: Int) {
        viewModelScope.launch {
            val gameModel = repository.getGameInfo(id)
            _gameLiveData.value = refactorGameModel(gameModel)
        }
    }

//    повторяющийся код с FinderViewModel, пока не придумал как оптимизировать
    private fun refactorGameModel(gameModelRetrofit: GameModelRetrofit): GameModel {
        return GameModel(
            id = gameModelRetrofit.id,
            backgroundImage = gameModelRetrofit.backgroundImage,
            genres = gameModelRetrofit.genres.joinToString(",", "", "", -1, "") { it.name },
            metacritic = gameModelRetrofit.metacritic,
            name = gameModelRetrofit.name,
            released = gameModelRetrofit.released
        )
    }
}