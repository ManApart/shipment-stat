import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MultiBaseTest {

    @Test
    fun simpleAdd() {
        val multi = MultiBaseInt(BaseInt(28, 0), BaseInt(3, 1), BaseInt(100, 0))

        val actual = multi.addAmount(0, 1)
        val expected = MultiBaseInt(BaseInt(28, 1), BaseInt(3, 1), BaseInt(100, 0))

        assertEquals(expected, actual)
    }


    @Test
    fun additionRolesOver() {
        val multi = MultiBaseInt(BaseInt(28, 0), BaseInt(3, 1), BaseInt(100, 0))

        val actual = multi.addAmount(0, 30)
        val expected = MultiBaseInt(BaseInt(28, 1), BaseInt(3, 2), BaseInt(100, 0))

        assertEquals(expected, actual)
    }

    @Test
    fun subtractionRollsOver() {
        val multi = MultiBaseInt(BaseInt(28, 0), BaseInt(3, 0), BaseInt(100, 1))

        val actual = multi.addAmount(0, -30)
        val expected = MultiBaseInt(BaseInt(28, 1), BaseInt(3, 3), BaseInt(100, 0))

        assertEquals(expected, actual)
    }
}