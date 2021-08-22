import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseIntTest {

    @Test
    fun acceptableRangeCheck(){
        val base = 10
        BaseInt(base, 0)
        BaseInt(base, 9)
        assertThrows<IllegalArgumentException> { BaseInt(base, -1) }
        assertThrows<IllegalArgumentException> { BaseInt(base, 10) }
    }

    @Test
    fun additionRolesOver(){
        val base = 10
        assertEquals(Pair(BaseInt(base, 1), 0), BaseInt(base, 0) + 1)
        assertEquals(Pair(BaseInt(base, 0), 1), BaseInt(base, 0) + 10)
        assertEquals(Pair(BaseInt(base, 5), 1), BaseInt(base, 0) + 15)
    }

    @Test
    fun subtractionRollsOver(){
        val base = 10
        assertEquals(Pair(BaseInt(base, 0), 0), BaseInt(base, 1) - 1)
        assertEquals(Pair(BaseInt(base, 0), -1), BaseInt(base, 0) -10)
        assertEquals(Pair(BaseInt(base, 5), -1), BaseInt(base, 0) -15)
    }
}