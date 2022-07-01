package com.larten.android.gamesfinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.databinding.FinderFragmentBinding


class FinderFragment : Fragment() {
    private lateinit var binding: FinderFragmentBinding
    lateinit var adapter: GamesAdapter
    private val viewModel: FinderViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FinderFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = GamesAdapter(object: ActionListener {
            override fun onGameDetails(game: GameModel) {
                TODO("Not yet implemented")
            }
        })
        binding.recyclerGames.adapter = adapter
        viewModel.getGames()
        viewModel.pageLiveData.observe(viewLifecycleOwner) {
            adapter.setList(it.results)
        }
    }
}