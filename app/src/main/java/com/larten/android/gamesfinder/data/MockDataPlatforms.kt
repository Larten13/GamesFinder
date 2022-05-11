package com.larten.android.gamesfinder.data

class MockDataPlatforms {

    fun loadPlatform(): Platform {
        val platforms = listOf(
            Platform(4, "PC", "pc"),
            Platform(187, "PlayStation 5", "playstation5"),
            Platform(1, "Xbox One", "xbox-one"),
            Platform(18, "PlayStation 4", "playstation4"),
            Platform(3, "iOS", "ios"),
            Platform(21, "Android", "android")
        )
        return platforms.random()
    }
}