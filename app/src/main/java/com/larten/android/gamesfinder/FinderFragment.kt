package com.larten.android.gamesfinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.larten.android.gamesfinder.databinding.FinderFragmentBinding


class FinderFragment : Fragment() {
    private lateinit var binding: FinderFragmentBinding
    private val adapter by lazy { GamesAdapter() }
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FinderFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[FinderViewModel::class.java]
        viewModel.getGames()
        recyclerView = binding.recyclerGames
        recyclerView.adapter = adapter
        viewModel.myGames.observe(viewLifecycleOwner) {
            adapter.setList(it.body()!!.results)
        }
    }
}