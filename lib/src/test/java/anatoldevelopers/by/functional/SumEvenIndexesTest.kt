package anatoldevelopers.by.functional

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SumEvenIndexesTest(private val list: List<Int>, private val result: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
                arrayOf(listOf(1, 2, 3, 4), 4),
                arrayOf(listOf(1, 0, 1, 0, 1, 0), 3),
                arrayOf(listOf(0, 1, 0, 1, 0, 1), 0)
        )
    }

    @Test
    fun maxSumFunctionReturnsCorrectResults() {
        assertEquals(result, sumWithEvenIndexes(list))
    }

}