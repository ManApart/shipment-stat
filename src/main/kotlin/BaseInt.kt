import kotlin.math.abs

data class BaseInt(private val highestNumber: Int = 9, val value: Int = 0) {
    init {
        require(value in 0..highestNumber) { "Value $value must be within $highestNumber" }
    }

    private val extra = highestNumber + 1

    /**
     * Returns the amount the next higher register should be changed
     */
    operator fun plus(amount: Int): Pair<BaseInt, Int> {
        var newAmount = value + amount
        var overflow = 0
        if (newAmount > highestNumber) {
            val remainder = newAmount % extra
            overflow = newAmount / extra
            newAmount = remainder
        }
        if (newAmount < 0) {
            if (abs(newAmount) < highestNumber) {
                newAmount += extra
                overflow -= 1
            } else {
                val remainder = newAmount % extra
                overflow = newAmount / extra
                newAmount = -remainder
            }
        }
        return Pair(BaseInt(highestNumber, newAmount), overflow)
    }

    operator fun minus(amount: Int): Pair<BaseInt, Int> {
        return plus(-amount)
    }
}