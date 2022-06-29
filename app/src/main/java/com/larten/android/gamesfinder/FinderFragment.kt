package com.larten.android.gamesfinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.larten.android.gamesfinder.databinding.FinderFragmentBinding


class FinderFragment : Fragment() {
    private lateinit var binding: FinderFragmentBinding
    private val adapter by lazy { GamesAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FinderFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this)[FinderViewModel::class.java]
        viewModel.getGames()
        binding.recyclerGames.adapter = adapter
        viewModel.pageLiveData.observe(viewLifecycleOwner) {
            adapter.setList(it.results)
        }
    }
}