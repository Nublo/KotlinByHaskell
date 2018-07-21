package anatoldevelopers.by.functional

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SumTest(private val list: List<Int>, private val result: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
                arrayOf(listOf(1, 2, 3, 4), 10),
                arrayOf(listOf(1, 0, 1, 0, 1, 0), 3),
                arrayOf(listOf(1), 1)
        )
    }

    @Test
    fun maxSumFunctionReturnsCorrectResults() {
        Assert.assertEquals(result, sum(list))
        Assert.assertEquals(result, sum2(list))
    }

}