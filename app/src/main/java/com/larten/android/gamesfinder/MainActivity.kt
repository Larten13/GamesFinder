package com.larten.android.gamesfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.larten.android.gamesfinder.databinding.ActivityMainBinding
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

const val QUERY = "query"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        searchView = binding.toolbar.menu.findItem(R.id.search_view).actionView as SearchView
        searchView.queryHint = "Search the game"
        lifecycleScope.launch {
            setupSearchView().debounce(600).collect{
                var query = bundleOf(QUERY to it)
                if (query.get(QUERY) != "") {
                    navController.navigate(R.id.finderFragment, query)
                } else {
                    navController.popBackStack()
                }
            }
        }

    }

    override fun onBackPressed() {
        navController.popBackStack()
    }
    private fun setupSearchView() = callbackFlow {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                trySend(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                trySend(newText)
                return true
            }
        })
        awaitClose { searchView.setOnQueryTextListener(null) }
    }
}