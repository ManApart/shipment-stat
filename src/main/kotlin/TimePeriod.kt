data class TimePeriod(val start: StardewDate, val end: StardewDate) {
    override fun toString(): String {
        return "$start through $end"
    }
    fun includes(date: StardewDate): Boolean {
        return date in start..end
    }
}
