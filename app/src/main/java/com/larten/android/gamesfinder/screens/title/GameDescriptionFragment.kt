package com.larten.android.gamesfinder.screens.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.larten.android.gamesfinder.R
import com.larten.android.gamesfinder.databinding.FragmentGameDescriptionBinding

class GameDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentGameDescriptionBinding
    private val viewModel: GameDescriptionViewModel by viewModels()
    private val args: GameDescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentId = args.id
        viewModel.getGameInfo(currentId)
        viewModel.gameLiveData.observe(viewLifecycleOwner) {
            Glide.with(this)
                .load(it.backgroundImage)
                .placeholder(R.drawable.ic_baseline_videogame_asset_24)
                .centerCrop()
                .into(binding.poster)
            binding.nameOfTitle.text = it.name
            binding.dateOfRelease.text = it.released
            binding.genres.text = it.genres
            binding.metaScore.text = getString(R.string.meta_score, it.metacritic)
            binding.description.text = it.description
        }
    }
}