import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TimePeriodTest {

    @Test
    fun includes() {
        val period = TimePeriod(StardewDate(0, 0, 1), StardewDate(1, 2, 3))
        assertTrue(period.includes(StardewDate(0, 0, 1)))
        assertTrue(period.includes(StardewDate(0, 1, 0)))
        assertTrue(period.includes(StardewDate(1, 2, 3)))

        assertFalse(period.includes(StardewDate(0, 0, 0)))
        assertFalse(period.includes(StardewDate(1, 2, 4)))
        assertFalse(period.includes(StardewDate(2, 0, 0)))
    }

}