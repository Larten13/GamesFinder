package com.larten.android.gamesfinder.screens.finder

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.larten.android.gamesfinder.screens.finder.adapter.games.GamesAdapter
import com.larten.android.gamesfinder.screens.finder.adapter.genres.GenresAdapter
import com.larten.android.gamesfinder.databinding.FinderFragmentBinding
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FinderFragment : Fragment() {

    private lateinit var binding: FinderFragmentBinding
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var genresAdapter: GenresAdapter
    private val viewModel: FinderViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FinderFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()

        lifecycleScope.launch {
            setupSearchView().debounce(400).collect {
                viewModel.search(it)
            }
        }
    }

    private fun setupSearchView() = callbackFlow {
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                trySend(query ?: "")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                trySend(newText ?: "")
                return false
            }
        })
        awaitClose { searchView.setOnQueryTextListener(null) }
    }

    private fun initAdapters() {
        gamesAdapter = GamesAdapter(
            object: GamesAdapter.OnItemClickListener {
                override fun onGameClick(gameId: Int) {
                    val action = FinderFragmentDirections.actionFinderFragmentToTitleFragment(gameId)
                    findNavController().navigate(action)
                }
            }
        )
        genresAdapter = GenresAdapter(
            object: GenresAdapter.OnItemClickListener {
                override fun onGenreClick(genreId: Int) {

                }
            }
        )

        binding.recyclerGames.adapter = gamesAdapter
        binding.recyclerGenres.adapter = genresAdapter

        viewModel.pageGamesLiveData.observe(viewLifecycleOwner) {
            gamesAdapter.setList(it.results)
        }

        viewModel.pageGenresLiveData.observe(viewLifecycleOwner) {
            genresAdapter.setGenresList(it.results)
        }
    }
}