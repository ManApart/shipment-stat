class StardewDate2(private val registers: MultiBaseInt) : Comparable<StardewDate2> {
    constructor(year: Int = 0, season: Int = 0, day: Int = 0) : this(
        MultiBaseInt(
            BaseInt(28, day),
            BaseInt(4, season),
            BaseInt(100, year)
        )
    )

    val day get() = registers.getValue(0)
    val season get() = registers.getValue(1)
    val year get() = registers.getValue(2)

    override fun toString(): String {
        return "$year-$season-$day"
    }

    fun addDays(i: Int): StardewDate2 {
        return StardewDate2(registers.addAmount(0, i))
    }

    fun addSeasons(i: Int): StardewDate2 {
        return StardewDate2(registers.addAmount(1, i))
    }

    fun addYears(i: Int): StardewDate2 {
        return StardewDate2(registers.addAmount(2, i))
    }

    operator fun plus(other: StardewDate2): StardewDate2 {
        return addDays(other.day).addSeasons(other.season).addYears(other.year)
    }

    override fun compareTo(other: StardewDate2): Int {
        return when {
            equals(other) -> 0
            year > other.year -> 1
            year == other.year && season > other.season -> 1
            year == other.year && season == other.season && day > other.day -> 1
            else -> -1
        }
    }
}