package parsing

import StardewDate

data class ShipmentDay(val date: StardewDate, val entries: List<ShipmentEntry>) {
    constructor(year: Int, month: Int, day: Int, entries: List<ShipmentEntry>) : this(
        StardewDate(year, month, day),
        entries
    )

//    val totalCount by lazy { entries.sumOf { it.count } }
//    val totalRevenue by lazy { entries.sumOf { it.count * it.price } }
}