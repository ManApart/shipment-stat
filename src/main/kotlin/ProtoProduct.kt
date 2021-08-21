
class ProtoProduct(val id: String, val category: String, val imageId: Int){
    val shipped = mutableMapOf<Long, Long>()

    fun toProduct(period: TimePeriod): Product {
        return Product(id, period, shipped, category, imageId)
    }
}