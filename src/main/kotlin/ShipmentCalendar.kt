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
        val productsMap = mutableMapOf<String, ProtoProduct>()
        days.filter { period.includes(it.date) }.forEach { day ->
            day.entries.forEach { entry ->
                val proto = productsMap.computeIfAbsent(entry.id) {
                    ProtoProduct(entry.id, entry.category, entry.imageId)
                }
                proto.shipped[entry.price] = proto.shipped.getOrDefault(entry.price, 0) + entry.count
            }
        }
        val shipped = productsMap.entries.associate { (id, shipped) ->
            id to shipped.toProduct(period)
        }
        return ShippedRange(period, shipped)
    }

}
