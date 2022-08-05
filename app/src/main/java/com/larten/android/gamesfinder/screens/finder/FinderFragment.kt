package com.larten.android.gamesfinder.screens.finder

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.larten.android.gamesfinder.GamesAdapter
import com.larten.android.gamesfinder.data.PageGamesModel
import com.larten.android.gamesfinder.databinding.FinderFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FinderFragment : Fragment() {

    private lateinit var binding: FinderFragmentBinding
    private lateinit var adapter: GamesAdapter
    private val viewModel: FinderViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FinderFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getGames()
        adapter = GamesAdapter(
            object: GamesAdapter.OnItemClickListener {
                override fun onItemClick(gameId: Int) {
                    val action = FinderFragmentDirections.actionFinderFragmentToTitleFragment(gameId)
                    findNavController().navigate(action)
                }
            }
        )
        binding.recyclerGames.adapter = adapter
        viewModel.pageLiveData.observe(viewLifecycleOwner) {
            adapter.setList(it.results)
        }
        setupSearchView()
    }

    private fun setupSearchView() {
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                lifecycleScope.launch {
                    viewModel.setQuery(newText)
                    viewModel.search(viewModel.searchFlow).collect {
                        adapter.setList(it.results)
                    }
                }
                return false
            }

        })
    }
}