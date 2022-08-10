package com.larten.android.gamesfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.larten.android.gamesfinder.databinding.ActivityMainBinding
import com.larten.android.gamesfinder.screens.main.MainViewModel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            setupSearchView().debounce(400).collect {
                MainViewModel().search(it)
            }
        }

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onBackPressed() {
        navController.popBackStack()
    }

    private fun setupSearchView() = callbackFlow {
        val searchView = binding.searchView
//        searchView.setOnClickListener {
//            navController.navigate(R.layout.fragment_finder)
//        }
        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
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
}