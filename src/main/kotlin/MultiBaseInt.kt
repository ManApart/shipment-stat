class MultiBaseInt(private vararg val registers: BaseInt) {

    fun getValue(register: Int): Int{
        return registers[register]!!.value
    }

    fun addAmount(register: Int, amount: Int): MultiBaseInt {
        TODO("Not yet implemented")
    }
}