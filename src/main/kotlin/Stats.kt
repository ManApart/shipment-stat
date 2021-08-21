import parsing.ShipmentDay

data class Stats(val header: Header, val days: List<ShipmentDay>){
    val calendar = ShipmentCalendar(days)
    val totalCount: Long by lazy { calendar.getPeriod(calendar.timePeriod).totalCount }
    val totalRevenue: Long by lazy { calendar.getPeriod(calendar.timePeriod).totalRevenue }
    val daysShipped = days.filter { it.entries.isNotEmpty() }.size
}
