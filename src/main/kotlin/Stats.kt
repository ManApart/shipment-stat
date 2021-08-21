import parsing.ShipmentDay

data class Stats(val header: Header, val days: List<ShipmentDay>){
    val calendar by lazy { ShipmentCalendar(days) }
    val totalCount: Long by lazy { days.sumOf { it.totalCount } }
    val totalRevenue: Long by lazy { days.sumOf { it.totalRevenue } }
}
