package com.larten.android.gamesfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.larten.android.gamesfinder.databinding.FindActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: FindActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FindActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}