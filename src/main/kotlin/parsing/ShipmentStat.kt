package parsing

import readConfig
import java.io.File
import java.text.DecimalFormat

fun main() {
    val config = readConfig()
    val stats = parseRawStats(File(config["statPath"]!! as String).readLines())

    println("During the period ${stats.calendar.timePeriod} " + stats.header.farmName + " has shipped " + stats.totalCount.format() + " items through " +stats.daysShipped + " shipments from ${stats.header.farmName} Farm, earning $" + stats.totalRevenue.format() + ".")

}

fun Long.format(): String {
    val dec = DecimalFormat("#,###,###")
    return dec.format(this)
}




