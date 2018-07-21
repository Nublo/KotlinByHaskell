package anatoldevelopers.by.functional

import org.junit.Assert.assertEquals
import org.junit.Test

class OperatorsTest {

    @Test
    fun elemPlusList_hasCorrectSize() {
        val list = 1 + listOf(1,2,3)
        assertEquals(4, list.size)
    }

    @Test
    fun listPlusElem_hasCorrectSize() {
        val list = listOf(1,2) + 3
        assertEquals(3, list.size)
    }

    @Test
    fun listPlusElem_hasCorrectLastElement() {
        val list = listOf(1,2) + 7
        assertEquals(7, list[2])
    }

    @Test
    fun listPlusList_hasCorrectSize() {
        val list = listOf(1,2) + listOf(1,2)
        assertEquals(4, list.size)
    }

    @Test
    fun zippingLists_hasCorrectSize() {
        val zip = zip(listOf(1,2,3,4), listOf(4,5))
        assertEquals(2, zip.size)
    }

}