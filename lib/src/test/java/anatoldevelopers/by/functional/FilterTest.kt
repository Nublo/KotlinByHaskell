package anatoldevelopers.by.functional

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class FilterTest(private val list: List<Int>, private val result: List<Int>) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : List<Array<List<Int>>> {
            return listOf(
                    arrayOf(listOf(1,2,3,-4,1,5), listOf(2,-4)),
                    arrayOf(listOf(0,1,0,1), listOf(0,0)),
                    arrayOf(listOf(1,1,1,1), listOf())
            )
        }
    }

    @Test
    fun filter() {
        assertEquals(result, list.filter { it % 2 == 0 })
    }

    @Test
    fun filter2() {
        assertEquals(result, list.filter2 { it % 2 == 0  })
    }

}