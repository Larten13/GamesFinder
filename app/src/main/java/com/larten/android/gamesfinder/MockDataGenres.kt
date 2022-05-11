package com.larten.android.gamesfinder

import com.larten.android.gamesfinder.R

class MockDataGenres {

    fun loadGenres(): List<Genre> {
        return listOf(
            Genre(4, "Action", "action", 149007, R.drawable.ic_action),
            Genre(51, "Indie", "indie", 44323, R.drawable.ic_indie),
            Genre(3, "Adventure", "adventure", 112413, R.drawable.ic_adventure),
            Genre(5, "RPG", "role-playing-games-rpg", 45661, R.drawable.ic_rpg),
            Genre(10, "Strategy", "strategy", 45487, R.drawable.ic_strategy),
            Genre(2, "Shooter", "shooter", 51447, R.drawable.ic_shooter),
            Genre(40, "Casual", "casual", 37957, R.drawable.ic_casual),
            Genre(14, "Simulation", "simulation", 56963, R.drawable.ic_simulator),
            Genre(7, "Puzzle", "puzzle", 84015, R.drawable.ic_puzzle)
        )
    }
}