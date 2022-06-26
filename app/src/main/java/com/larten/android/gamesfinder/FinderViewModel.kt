package com.larten.android.gamesfinder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larten.android.gamesfinder.data.PageGamesModel
import com.larten.android.gamesfinder.retrofit.RetrofitRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class FinderViewModel: ViewModel() {
    private val repository = RetrofitRepo()
    val myGames: MutableLiveData<Response<PageGamesModel>> = MutableLiveData()

    fun getGames() {
        viewModelScope.launch {
            myGames.value = repository.getGames()
        }
    }
}