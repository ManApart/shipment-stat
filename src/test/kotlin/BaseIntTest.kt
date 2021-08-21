import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseIntTest {

    @Test
    fun acceptableRangeCheck(){
        val range = 9
        BaseInt(range, 0)
        BaseInt(range, 9)
        assertThrows<IllegalArgumentException> { BaseInt(range, -1) }
        assertThrows<IllegalArgumentException> { BaseInt(range, 10) }
    }

    @Test
    fun additionRolesOver(){
        val range = 9
        assertEquals(Pair(BaseInt(range, 1), 0), BaseInt(range, 0) + 1)
        assertEquals(Pair(BaseInt(range, 0), 1), BaseInt(range, 0) + 10)
        assertEquals(Pair(BaseInt(range, 5), 1), BaseInt(range, 0) + 15)
    }

    @Test
    fun subtractionRollsOver(){
        val range = 9
        assertEquals(Pair(BaseInt(range, 0), 0), BaseInt(range, 1) - 1)
        assertEquals(Pair(BaseInt(range, 0), -1), BaseInt(range, 0) -10)
        assertEquals(Pair(BaseInt(range, 5), -1), BaseInt(range, 0) -15)
    }
}