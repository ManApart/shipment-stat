class ShippedRange(val timePeriod: TimePeriod, val products: Map<String, Product>) {
    val totalCount by lazy { products.values.sumOf { it.totalCount } }
    val totalRevenue by lazy { products.values.sumOf { it.totalRevenue } }
}