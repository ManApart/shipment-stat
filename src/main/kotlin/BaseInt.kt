import kotlin.math.abs

data class BaseInt(private val acceptableRange: IntRange = 0..9, val value: Int = 0) {
    init {
        require(value in acceptableRange) { "Value $value must be within $acceptableRange" }
    }

    private val highest = acceptableRange.last
    private val distance =  acceptableRange.last - acceptableRange.first
    private val extra = distance + 1

    /**
     * Returns the amount the next higher register should be changed
     */
    operator fun plus(amount: Int): Pair<BaseInt, Int> {
        var newAmount = value + amount
        var overflow = 0
        if (newAmount > highest) {
            val remainder = newAmount % extra
            overflow = newAmount / extra
            newAmount = remainder
        }
        if (newAmount < 0) {
            if (abs(newAmount) < highest) {
                newAmount += extra
                overflow -= 1
            } else {
                val remainder = newAmount % extra
                overflow = newAmount / extra
                newAmount = -remainder
            }
        }
        return Pair(BaseInt(acceptableRange, newAmount), overflow)
    }

    operator fun minus(amount: Int): Pair<BaseInt, Int> {
        return plus(-amount)
    }
}