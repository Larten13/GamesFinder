package com.larten.android.gamesfinder.data


class MockDataGames {

    fun loadGames(): Array<String> {
        val games = arrayOf(
            Game(
                3498,
                "Grand Theft Auto V",
                "grand-theft-auto-v",
                "2013-09-17",
                92,
                MockDataGenres().loadGenre(),
                MockDataPlatforms().loadPlatform()
            ),
            Game(
                3328,
                "The Witcher 3: Wild Hunt",
                "the-witcher-3-wild-hunt",
                "2015-05-18",
                92,
                MockDataGenres().loadGenre(),
                MockDataPlatforms().loadPlatform()
            ),
            Game(
                5286,
                "Tomb Raider (2013)",
                "tomb-raider",
                "2013-03-05",
                86,
                MockDataGenres().loadGenre(),
                MockDataPlatforms().loadPlatform()
            ),
            Game(
                5679,
                "The Elder Scrolls V: Skyrim",
                "the-elder-scrolls-v-skyrim",
                "2011-11-11",
                94,
                MockDataGenres().loadGenre(),
                MockDataPlatforms().loadPlatform()
            ),
            Game(
                4291,
                "Counter-Strike: Global Offensive",
                "counter-strike-global-offensive",
                "2012-08-21",
                81,
                MockDataGenres().loadGenre(),
                MockDataPlatforms().loadPlatform()
            ),
            Game(
                12020,
                "Left 4 Dead 2",
                "left-4-dead-2",
                "2009-11-17",
                89,
                MockDataGenres().loadGenre(),
                MockDataPlatforms().loadPlatform()
            ),
            Game(
                13536,
                "Portal",
                "portal",
                "2007-10-09",
                90,
                MockDataGenres().loadGenre(),
                MockDataPlatforms().loadPlatform()
            ),
            Game(
                4062,
                "BioShock Infinite",
                "bioshock-infinite",
                "2013-03-26",
                94,
                MockDataGenres().loadGenre(),
                MockDataPlatforms().loadPlatform()
            ),
            Game(
                3439,
                "Life is Strange",
                "life-is-strange-episode-1-2",
                "2015-01-29",
                83,
                MockDataGenres().loadGenre(),
                MockDataPlatforms().loadPlatform()
            )
        )
        val names = games.map { it.name }.toTypedArray()
        return names
    }
}