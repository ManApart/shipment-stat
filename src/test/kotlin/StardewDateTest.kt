import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StardewDateTest {

    @Test
    fun addDay() {
        val start = StardewDate(0, 0, 10)

        assertEquals(StardewDate(0, 0, 10), start.addDays(0))
        assertEquals(StardewDate(0, 0, 11), start.addDays(1))
        assertEquals(StardewDate(0, 0, 15), start.addDays(5))
        assertEquals(StardewDate(0, 0, 8), start.addDays(-2))
    }

    @Test
    fun addMonth() {
        val start = StardewDate(0, 1, 0)

        assertEquals(StardewDate(0, 1, 0), start.addSeasons(0))
        assertEquals(StardewDate(0, 2, 0), start.addSeasons(1))
        assertEquals(StardewDate(0, 0, 0), start.addSeasons(-1))
    }

    @Test
    fun addYear() {
        val start = StardewDate(5, 0, 0)

        assertEquals(StardewDate(5, 0, 0), start.addYears(0))
        assertEquals(StardewDate(6, 0, 0), start.addYears(1))
        assertEquals(StardewDate(3, 0, 0), start.addYears(-2))
    }

    @Test
    fun addDate() {
        val start = StardewDate(0, 0, 0)

        assertEquals(StardewDate(0, 0, 1), start + StardewDate(0, 0, 1))
        assertEquals(StardewDate(0, 2, 0), start + StardewDate(0, 2, 0))
        assertEquals(StardewDate(3, 0, 0), start + StardewDate(3, 0, 0))
    }

    @Test
    fun compareDates() {
        val start = StardewDate(1, 1, 3)
        assertTrue(start > StardewDate(0, 0, 0))
        assertTrue(start > StardewDate(0, 3, 6))
        assertTrue(start > StardewDate(1, 0, 6))
        assertTrue(start > StardewDate(1, 1, 2))
        assertTrue(start == StardewDate(1, 1, 3))
        assertTrue(start < StardewDate(2, 0, 0))
        assertTrue(start < StardewDate(1, 1, 4))
        assertTrue(start < StardewDate(1, 2, 0))
    }

    @Test
    fun changeBoundaries() {
        assertEquals(StardewDate(0, 1, 0), StardewDate(0,0,27).addDays(1))
        assertEquals(StardewDate(0, 1, 1), StardewDate(0,0,27).addDays(2))
        assertEquals(StardewDate(0, 0, 26), StardewDate(0,1,0).addDays(-2))

        assertEquals(StardewDate(1, 0, 0), StardewDate(0,3,0).addSeasons(1))
        assertEquals(StardewDate(1, 1, 0), StardewDate(0,3,0).addSeasons(2))
        assertEquals(StardewDate(0, 2, 0), StardewDate(1,0,0).addSeasons(-2))

        assertEquals(StardewDate(1, 0, 0), StardewDate(0,3,27).addDays(1))
        assertEquals(StardewDate(1, 0, 1), StardewDate(0,3,27).addDays(2))


        assertEquals(StardewDate(1, 0, 0), StardewDate(0,0,0).addDays(28 * 4))
        assertEquals(StardewDate(0, 0, 0), StardewDate(1,0,0).addDays(-28 * 4))
    }

}