package anatoldevelopers.by.functional

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.Assert.assertEquals

@RunWith(Parameterized::class)
class MaxSumTest(private val list: List<Int>, private val result: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf(1,2,3,-4,1,5), 6),
                    arrayOf(listOf(1,2,3,4,5,6), 11),
                    arrayOf(listOf(-11,11,-11,0,0,1,1,0), 2)
            )
        }
    }

    @Test
    fun maxSumFunctionReturnsCorrectResults() {
        assertEquals(result, maxSum(list))
    }

}