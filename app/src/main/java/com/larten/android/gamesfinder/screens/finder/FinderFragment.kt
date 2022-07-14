package com.larten.android.gamesfinder.screens.finder

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.larten.android.gamesfinder.GamesAdapter
import com.larten.android.gamesfinder.data.GameModel
import com.larten.android.gamesfinder.databinding.FinderFragmentBinding

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
    }
}