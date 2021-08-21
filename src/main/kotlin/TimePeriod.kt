data class TimePeriod(val start: StardewDate, val end: StardewDate) {
    override fun toString(): String {
        return if (start == end) {
            start.toString()
        } else {
            "$start through $end"
        }
    }

    fun includes(date: StardewDate): Boolean {
        return date in start..end
    }

    fun daysElapsed(): Int {
        return 28
    }
}
