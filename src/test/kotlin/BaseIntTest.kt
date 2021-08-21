import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseIntTest {

    @Test
    fun acceptableRangeCheck(){
        val highest = 9
        BaseInt(highest, 0)
        BaseInt(highest, 9)
        assertThrows<IllegalArgumentException> { BaseInt(highest, -1) }
        assertThrows<IllegalArgumentException> { BaseInt(highest, 10) }
    }

    @Test
    fun additionRolesOver(){
        val highest = 9
        assertEquals(Pair(BaseInt(highest, 1), 0), BaseInt(highest, 0) + 1)
        assertEquals(Pair(BaseInt(highest, 0), 1), BaseInt(highest, 0) + 10)
        assertEquals(Pair(BaseInt(highest, 5), 1), BaseInt(highest, 0) + 15)
    }

    @Test
    fun subtractionRollsOver(){
        val highest = 9
        assertEquals(Pair(BaseInt(highest, 0), 0), BaseInt(highest, 1) - 1)
        assertEquals(Pair(BaseInt(highest, 0), -1), BaseInt(highest, 0) -10)
        assertEquals(Pair(BaseInt(highest, 5), -1), BaseInt(highest, 0) -15)
    }
}