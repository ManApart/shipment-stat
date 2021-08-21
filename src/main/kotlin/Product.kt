typealias PriceToCount = Map<Long, Long>

class Product(val id: String, val timePeriod: TimePeriod, val shipped: PriceToCount, val category: String, val imageId: Int) {
    val totalCount by lazy { shipped.values.sum() }
    val totalRevenue by lazy { shipped.entries.sumOf { it.key * it.value } }
}