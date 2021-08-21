import parsing.ShipmentDay

data class Stats(val header: Header, val days: List<ShipmentDay>){
    val calendar = ShipmentCalendar(days)
    val totals = calendar.getPeriod(calendar.timePeriod)
    val totalCount = totals.totalCount
    val totalRevenue = totals.totalRevenue
    val daysShipped = days.filter { it.entries.isNotEmpty() }.size
}
