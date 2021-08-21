import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseIntTest {

    @Test
    fun acceptableRangeCheck(){
        val range = 0..10
        BaseInt(range, 0)
        BaseInt(range, 10)
        assertThrows<IllegalArgumentException> { BaseInt(range, -1) }
        assertThrows<IllegalArgumentException> { BaseInt(range, 11) }
    }

    @Test
    fun additionRolesOver(){
        val range = 0..9
        assertEquals(Pair(BaseInt(range, 1), 0), BaseInt(range, 0) + 1)
        assertEquals(Pair(BaseInt(range, 0), 1), BaseInt(range, 0) + 10)
        assertEquals(Pair(BaseInt(range, 5), 1), BaseInt(range, 0) + 15)
    }

    @Test
    fun subtractionRollsOver(){
        val range = 0..9
        assertEquals(Pair(BaseInt(range, 0), 0), BaseInt(range, 1) - 1)
        assertEquals(Pair(BaseInt(range, 0), -1), BaseInt(range, 0) -10)
        assertEquals(Pair(BaseInt(range, 5), -1), BaseInt(range, 0) -15)
    }
}