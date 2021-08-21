package parsing

import readConfig
import java.io.File
import java.text.DecimalFormat

fun main() {
    val config = readConfig()
    val stats = parseRawStats(File(config["statPath"]!! as String).readLines())

    val farmer = stats.header.playerName

    println("During the period ${stats.calendar.timePeriod} " + farmer + " has shipped " + stats.totalCount.format() + " items through " + stats.daysShipped + " shipments from ${stats.header.farmName} Farm, earning $" + stats.totalRevenue.format() + ".")

    println("$farmer has sold " + stats.totals.products.size + " different products in " + stats.totals.products.values.groupBy { it.category }.size + " categories.")

    val mostProfitable = stats.totals.products.values.maxByOrNull { it.totalRevenue }!!
    println("$farmer's most profitable crop is ${mostProfitable.id}. ${mostProfitable.totalCount.format()} sold for a profit of ${mostProfitable.totalRevenue.format()}")

    val mostSold = stats.totals.products.values.maxByOrNull { it.totalCount }!!
    println("$farmer's most sold crop is ${mostSold.id}. ${mostSold.totalCount.format()} sold for a profit of ${mostSold.totalRevenue.format()}")

}

fun Long.format(): String {
    val dec = DecimalFormat("#,###,###")
    return dec.format(this)
}




