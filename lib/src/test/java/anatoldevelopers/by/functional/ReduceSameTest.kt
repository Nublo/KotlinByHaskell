package anatoldevelopers.by.functional

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ReduceSameTest(private val list: List<Int>, private val reverse: List<Int>) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
                arrayOf(listOf(1, 2, 3, 4), listOf(4, 3, 2, 1)),
                arrayOf(listOf(0,1,-1), listOf(-1,1,0)),
                arrayOf(listOf(1), listOf(1))
        )
    }

    @Test
    fun reduceSameReturnSameList() {
        assertEquals(list, reduceSame(list))
    }

    @Test
    fun reverseReturnsReversedList() {
        assertEquals(reverse, reverse(list))
    }

}