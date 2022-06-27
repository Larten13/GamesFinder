package com.larten.android.gamesfinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.larten.android.gamesfinder.data.PageGamesModel
import com.larten.android.gamesfinder.databinding.FinderFragmentBinding
import com.larten.android.gamesfinder.retrofit.RetrofitRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class FinderFragment : Fragment() {
    private lateinit var binding: FinderFragmentBinding
    private val adapter by lazy { GamesAdapter() }
    private val games: MutableLiveData<Response<PageGamesModel>> = MutableLiveData()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FinderFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        CoroutineScope(Dispatchers.Main).launch {
            games.value = RetrofitRepo().getGames()
        }
        binding.recyclerGames.adapter = adapter
        games.observe(viewLifecycleOwner) {
            adapter.setList(it.body()!!.results)
        }
    }

}