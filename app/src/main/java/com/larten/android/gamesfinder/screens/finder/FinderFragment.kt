package com.larten.android.gamesfinder.screens.finder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.larten.android.gamesfinder.R
import com.larten.android.gamesfinder.databinding.FragmentFinderBinding
import com.larten.android.gamesfinder.screens.main.adapter.games.GamesAdapter

class FinderFragment : Fragment() {

    private lateinit var binding: FragmentFinderBinding
    private lateinit var adapter: GamesAdapter
    private val viewModel: FinderViewModel by viewModels()
    private val args: FinderFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFinderBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val currentGenre = args.nameOfGenre
        viewModel.getGamesOfGenres(currentGenre)
        adapter = GamesAdapter(
            object: GamesAdapter.OnItemClickListener {
                override fun onItemClick(gameId: Int) {
                    val action = FinderFragmentDirections.actionFinderFragmentToTitleFragment(gameId)
                    findNavController().navigate(action)
                }
            },
            _viewType = R.layout.game_finder_item
        )

        binding.recyclerFinder.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerFinder.adapter = adapter

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setList(it.results)
        }
    }
}