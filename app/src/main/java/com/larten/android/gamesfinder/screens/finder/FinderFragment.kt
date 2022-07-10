package com.larten.android.gamesfinder.screens.finder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.larten.android.gamesfinder.GamesAdapter
import com.larten.android.gamesfinder.R
import com.larten.android.gamesfinder.databinding.FinderFragmentBinding
import com.larten.android.gamesfinder.screens.title.GameDescriptionFragment

class FinderFragment : Fragment() {
    private lateinit var binding: FinderFragmentBinding
    private val adapter by lazy { GamesAdapter() }
    private val viewModel: FinderViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FinderFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerGames.adapter = adapter
        viewModel.getGames()
        viewModel.pageLiveData.observe(viewLifecycleOwner) {
            adapter.setList(it.results)
        }
    }
}