package parsing

import readConfig
import java.io.File
import java.text.DecimalFormat

fun main() {
    val config = readConfig()
    val stats = parseRawStats(File(config["statPath"]!! as String).readLines())

    println(stats.header.farmName + " has shipped " + stats.totalCount.format() + " items from ${stats.header.farmName}, earning $" + stats.totalRevenue.format())

}

fun Long.format(): String {
    val dec = DecimalFormat("#,###,###")
    return dec.format(this)
}




