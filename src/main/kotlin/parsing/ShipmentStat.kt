package parsing

import StardewDate
import Stats
import readConfig
import java.io.File
import java.text.DecimalFormat

fun main() {
    val config = readConfig()
    val stats = parseRawStats(File(config["statPath"]!! as String).readLines())

    with(stats) {
        val farmer = header.playerName

        println("\n\n-------------------------------------------\n")

        overviewInfo(farmer)
        bestProductsInfo(farmer)
        bestDayInfo()
        seasonalInfo(farmer)
    }
}


private fun Stats.overviewInfo(farmer: String) {
    println("During the period ${calendar.timePeriod} " + farmer + " has shipped " + totalCount.format() + " items through " + daysShipped + " shipments from ${header.farmName} Farm, earning $" + totalRevenue.format() + ".")

    println("$farmer has sold " + totals.products.size.format() + " different products in " + totals.products.values.groupBy { it.category }.size + " categories.")
}

private fun Stats.bestProductsInfo(farmer: String) {
    val mostProfitable = totals.products.values.maxByOrNull { it.totalRevenue }!!
    println("$farmer's most profitable crop is ${mostProfitable.id}. ${mostProfitable.totalCount.format()} sold for a profit of $${mostProfitable.totalRevenue.format()}")

    val mostSold = totals.products.values.maxByOrNull { it.totalCount }!!
    println("$farmer's most sold crop is ${mostSold.id}. ${mostSold.totalCount.format()} sold for a profit of $${mostSold.totalRevenue.format()}")
}

private fun Stats.bestDayInfo() {
    val profitableShipment = calendar.days.maxByOrNull { it.revenue }!!
    val profitableShipped = calendar.getDay(profitableShipment.date)
    println("The most profitable single shipment was on ${profitableShipped.timePeriod}, with a profit of $${profitableShipped.totalRevenue.format()}")
}

private fun Stats.seasonalInfo(farmer: String) {
    (0..totals.timePeriod.end.year).forEach { year ->
        (0..totals.timePeriod.end.season).forEach { season ->
            val period = calendar.getSeason(StardewDate(year, season, 0))
            if (period.totalRevenue > 0) {
                println("In ${season(season)} of year $year, $farmer shipped ${period.totalCount.format()} crops for ${period.totalRevenue.format()}. This is an average of ${period.averageCount.format()} crops at $${period.averageRevenue.format()} a day.")
            }
        }
    }
}

fun Int.format(): String {
    return toLong().format()
}

fun Long.format(): String {
    val dec = DecimalFormat("#,###,###")
    return dec.format(this)
}

fun season(ordinal: Int): String {
    return when (ordinal){
        0 -> "Spring"
        1 -> "Summer"
        2 -> "Fall"
        3 -> "Winter"
        else -> "Unknown"
    }
}



