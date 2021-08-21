import parsing.ShipmentDay

class ShipmentCalendar(private val days: List<ShipmentDay>) {
    val timePeriod = TimePeriod(days.minOf { it.date }, days.maxOf { it.date })

    fun getDay(stardewDate: StardewDate): ShippedRange {
        return getPeriod(TimePeriod(stardewDate, stardewDate.addDays(1)))
    }

    fun getMonth(stardewDate: StardewDate): ShippedRange {
        return getPeriod(TimePeriod(stardewDate, stardewDate.addSeasons(1)))
    }

    fun getYear(stardewDate: StardewDate): ShippedRange {
        return getPeriod(TimePeriod(stardewDate, stardewDate.addYears(1)))
    }

    fun getPeriod(period: TimePeriod): ShippedRange {
        return ShippedRange(period, mapOf())
    }

}
