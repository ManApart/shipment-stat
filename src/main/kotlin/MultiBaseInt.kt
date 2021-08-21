data class MultiBaseInt(private val registers: List<BaseInt>) {
    constructor(vararg registers: BaseInt) : this(registers.toList())

    fun getValue(register: Int): Int {
        return registers[register].value
    }

    fun addAmount(register: Int, amount: Int): MultiBaseInt {
        var overflow = 0
        val updated = registers.mapIndexed { i, reg ->
            if (i == register) {
                overflow = amount
            }

            val (actual, remainder) = reg + overflow
            overflow = remainder
            actual
        }
        return MultiBaseInt(updated)
    }
}