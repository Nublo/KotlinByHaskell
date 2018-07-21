package anatoldevelopers.by.functional

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MapTest(private val list: List<Int>, private val result: List<Int>) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<List<Int>>> {
            return listOf(
                    arrayOf(listOf(1, 2, 3, -4, 1, 5), listOf(2, 4, 6, -8, 2, 10)),
                    arrayOf(listOf(0, 1, 0, 1), listOf(0, 2, 0, 2)),
                    arrayOf(listOf(1, 1, 1, 1), listOf(2, 2, 2, 2))
            )
        }
    }

    @Test
    fun map() {
        Assert.assertEquals(result, list.map { it * 2 })
    }

    @Test
    fun map2() {
        Assert.assertEquals(result, list.map2 { it * 2 })
    }

}