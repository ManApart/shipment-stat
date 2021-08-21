class BaseInt(val acceptableRange: IntRange, initialValue: Int) {
    private var internalValue = initialValue
    val value get() = internalValue

    /**
     * Returns the amount the next higher register should be changed
     */
    operator fun plus(amount: Int) : Int {
        return 0
    }
}