import kotlin.math.abs

data class BaseInt(private val base: Int = 10, val value: Int = 0) {
    private val highestNumber = base - 1
    init {
        require(value in 0..highestNumber) { "Value $value must be within 0..$highestNumber" }
    }


    /**
     * Returns the amount the next higher register should be changed
     */
    operator fun plus(amount: Int): Pair<BaseInt, Int> {
        var newAmount = value + amount
        var overflow = 0
        if (newAmount > highestNumber) {
            val remainder = newAmount % base
            overflow = newAmount / base
            newAmount = remainder
        }
        if (newAmount < 0) {
            if (abs(newAmount) < highestNumber) {
                newAmount += base
                overflow -= 1
            } else {
                val remainder = newAmount % base
                overflow = newAmount / base
                newAmount = -remainder
            }
        }
        return Pair(BaseInt(base, newAmount), overflow)
    }

    operator fun minus(amount: Int): Pair<BaseInt, Int> {
        return plus(-amount)
    }
}