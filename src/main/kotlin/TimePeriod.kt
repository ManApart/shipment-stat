data class TimePeriod(val start: StardewDate, val end: StardewDate) {
    fun includes(date: StardewDate): Boolean {
        return false
    }
}