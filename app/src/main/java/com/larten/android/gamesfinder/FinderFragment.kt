package com.larten.android.gamesfinder

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import com.larten.android.gamesfinder.databinding.FinderFragmentBinding


class FinderFragment : Fragment() {
    private lateinit var binding: FinderFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FinderFragmentBinding.inflate(inflater)
        return binding.root
    }
}