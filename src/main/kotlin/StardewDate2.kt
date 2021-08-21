import kotlin.math.abs

class StardewDate2(private val registers: MultiBaseInt){
    constructor(year: Int = 0, season: Int = 0, day: Int = 0) : this (MultiBaseInt(BaseInt(0..28, day), BaseInt(0..3, season), BaseInt(0..100, year)))

    val day get() = registers.getValue(0)
    val season get() = registers.getValue(1)
    val year get() = registers.getValue(2)

//    init {
//        require(day in 0..27) { "Day $day is out of bounds!" }
//        require(season in 0..3) { "Season $season is out of bounds!" }
//    }

//    override fun toString(): String {
//        return "$year-$season-$day"
//    }
//
    fun addDays(i: Int): StardewDate2 {
//        return buildRollingDate(year, season, day + i)
        return StardewDate2(registers.addAmount(0, i))
    }
//
//    fun addSeasons(i: Int): StardewDate2 {
//        return buildRollingDate(year, season + i, day)
//    }
//
//    fun addYears(i: Int): StardewDate2 {
//        return buildRollingDate(year + i, season, day)
//    }
//
//    operator fun plus(other: StardewDate2): StardewDate2 {
//        return buildRollingDate(year + other.year, season + other.season, day + other.day)
//    }
//
//    private fun buildRollingDate(year: Int, season: Int, day: Int): StardewDate2 {
//        var newDay = day
//        var newSeason = season
//        var newYear = year
//        if (day > 27) {
//            val remainder = newDay % 28
//            val seasonAdd = newDay / 28
//            newDay = remainder
//            newSeason += seasonAdd
//        }
//        if (day < 0) {
//            if (abs(day) < 28) {
//                newDay += 28
//                newSeason -= 1
//            } else {
//                val remainder = newDay % 28
//                val seasonAdd = newDay / 28
//                newDay = -remainder
//                newSeason += seasonAdd
//            }
//        }
//        if (newSeason > 3) {
//            val remainder = newSeason % 4
//            val yearAdd = newSeason / 4
//            newSeason = remainder
//            newYear += yearAdd
//        }
//        if (newSeason < 0) {
//            if (abs(newSeason) < 4) {
//                newSeason += 4
//                newYear -= 1
//            } else {
//                val remainder = newSeason % 4
//                val yearAdd = newSeason / 4
//                newSeason = -remainder
//                newYear += yearAdd
//            }
//        }
//
//        return StardewDate2(newYear, newSeason, newDay)
//    }
//
//    override fun compareTo(other: StardewDate2): Int {
//        return when {
//            equals(other) -> 0
//            year > other.year -> 1
//            year == other.year && season > other.season -> 1
//            year == other.year && season == other.season && day > other.day -> 1
//            else -> -1
//        }
//    }
}