package parsing

import Header
import Stats
import java.util.*

fun parseRawStats(lines: List<String>): Stats {
    val header = parseHeader(lines)
    val entries = parseDays(lines)
    return Stats(header, entries)
}

private fun parseHeader(lines: List<String>): Header {
    val line = lines.first().split(",")
    return Header(line[0], line[1], Date(line[2].toLong()))
}

private fun parseDays(lines: List<String>): List<ShipmentDay> {
    return lines.subList(1, lines.size).mapIndexed { i, line ->
        try {
            parseDay(line)
        } catch (e: Exception) {
            println("Failed to parse line ${i+2}: $line")
            println(e)
            null
        }
    }.filterNotNull()
}

private fun parseDay(line: String): ShipmentDay {
    val parts = line.split(",")
    val entries = parts.subList(3, parts.size).chunked(5).map { entryParts ->
        ShipmentEntry(entryParts[0], entryParts[1].toLong(), entryParts[2].toLong(), entryParts[3], entryParts[4].toInt())
    }

    return ShipmentDay(parts[0].toInt(), parts[1].toInt(), parts[2].toInt(), entries)
}