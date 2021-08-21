class ShippedRange(val timePeriod: TimePeriod, val products: Map<String, Product>) {
    val totalCount by lazy { products.values.sumOf { it.totalCount } }
    val totalRevenue by lazy { products.values.sumOf { it.totalRevenue } }

    val averageCount by lazy { totalCount / timePeriod.daysElapsed() }
    val averageRevenue by lazy { totalRevenue / timePeriod.daysElapsed() }
}