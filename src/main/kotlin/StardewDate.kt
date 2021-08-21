data class StardewDate(val year: Int = 0, val season: Int = 0, val day: Int = 0) : Comparable<StardewDate> {
    init {
        require(day in 0..27) { "Day $day is out of bounds!" }
        require(season in 0..3) { "Season $season is out of bounds!" }
    }

    fun addDays(i: Int): StardewDate {
        return buildRollingDate(year, season, day + i)
    }

    fun addSeasons(i: Int): StardewDate {
        return buildRollingDate(year, season + i, day)
    }

    fun addYears(i: Int): StardewDate {
        return buildRollingDate(year + i, season, day)
    }

    operator fun plus(other: StardewDate): StardewDate {
        return buildRollingDate(year + other.year, season + other.season, day + other.day)
    }

    private fun buildRollingDate(year: Int, season: Int, day: Int): StardewDate {
        var newDay = day
        var newSeason = season
        var newYear = year
        if (day > 27) {
            newDay -= 28
            newSeason += 1
        }
        if (day < 0) {
            newDay += 28
            newSeason -= 1
        }
        if (newSeason > 3) {
            newSeason -= 4
            newYear += 1
        }
        if (newSeason < 0) {
            newSeason = 3 - 1
            newYear -= 1
        }

        return StardewDate(newYear, newSeason, newDay)
    }

    override fun compareTo(other: StardewDate): Int {
        return when {
            equals(other) -> 0
            year > other.year -> 1
            year == other.year && season > other.season -> 1
            year == other.year && season == other.season && day > other.day -> 1
            else -> -1
        }
    }
}