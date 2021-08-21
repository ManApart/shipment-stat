package parsing

data class ShipmentDay(val year: Int, val month: Int, val day: Int, val entries: List<ShipmentEntry>){
    val totalCount by lazy { entries.sumOf { it.count } }
    val totalRevenue by lazy { entries.sumOf { it.count * it.price } }
}