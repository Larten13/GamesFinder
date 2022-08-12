package com.larten.android.gamesfinder.screens.main

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.larten.android.gamesfinder.R
import com.larten.android.gamesfinder.screens.main.adapter.games.GamesAdapter
import com.larten.android.gamesfinder.screens.main.adapter.genres.GenresAdapter
import com.larten.android.gamesfinder.databinding.MainFragmentBinding
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var genresAdapter: GenresAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        viewModel.pageGamesLiveData.observe(viewLifecycleOwner) {
            gamesAdapter.setList(it.results)
        }

        viewModel.pageGenresLiveData.observe(viewLifecycleOwner) {
            genresAdapter.setGenresList(it.results)
        }
    }


    private fun initAdapters() {
        gamesAdapter = GamesAdapter(
            object: GamesAdapter.OnItemClickListener {
                override fun onGameClick(gameId: Int) {
                    val action = MainFragmentDirections.actionMainFragmentToTitleFragment(gameId)
                    findNavController().navigate(action)
                }
            },
            _viewType = R.layout.game_item
        )
        genresAdapter = GenresAdapter(
            object: GenresAdapter.OnItemClickListener {
                override fun onGenreClick(genre: String) {
                    val action = MainFragmentDirections.actionMainFragmentToFinderFragment().setGenre(genre)
                    findNavController().navigate(action)
                }
            }
        )

        binding.recyclerGames.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerGames.adapter = gamesAdapter
        binding.recyclerGenres.adapter = genresAdapter
    }
}