package anatoldevelopers.by.functional

val <T> List<T>.head: T
    get() = when (this.isEmpty()) {
        true -> throw NoSuchElementException("List is empty.")
        false -> this[0]
    }

val <T> List<T>.tail: List<T>
    get() = drop(1)

val List<Int>.sum: Int
    get() = sum(this)

fun sum(xs: List<Int>): Int {

    tailrec fun sumInner(xs: List<Int>, acum: Int): Int = when (xs.size) {
        0 -> acum
        else -> sumInner(xs.tail, xs.head + acum)
    }

    return sumInner(xs, 0)
}

fun sum2(xs: List<Int>) = reduce(0, xs) { acum, current -> acum + current }

fun <T, R> List<T>.map(f: (T) -> R): List<R> = when (this.size) {
    0 -> mutableListOf()
    else -> f(head) + tail.map(f)
}

fun <T, R> List<T>.map2(f: (T) -> R): List<R> = reduce(mutableListOf(), this)
{ xs, s -> (xs + f(s)).toMutableList() }

fun <T> List<T>.filter(f: (T) -> Boolean): List<T> = when (this.size) {
    0 -> mutableListOf()
    else -> if (f(head)) head + tail.filter(f) else tail.filter(f)
}

fun <T> List<T>.filter2(f: (T) -> Boolean): List<T> = reduce(mutableListOf(), this)
{ ys, s ->
    if (f(s))
        return@reduce (ys + s).toMutableList()
    else
        ys
}

fun <T, R> reduce(s: T, xs: List<R>, f: (T, R) -> T): T = when (xs.size) {
    0 -> s
    else -> reduce(f(s, xs.head), xs.tail, f)
}

operator fun <T> List<T>.plus(x: T): List<T> = ArrayList(this).also { it.add(x) }

operator fun <T> List<T>.plus(xs: List<T>): List<T> = when (xs.size) {
    0 -> ArrayList(this)
    else -> (this + xs.head) + xs.tail
}

operator fun <T> T.plus(xs: List<T>): List<T> = mutableListOf(this) + xs

fun <T, R> zip(xs: List<T>, ys: List<R>): List<Pair<T, R>> = when (xs.isEmpty() || ys.isEmpty()) {
    true -> mutableListOf()
    false -> Pair(xs.head, ys.head) + zip(xs.tail, ys.tail)
}

fun <T, R, C> zipWith(xs: List<T>, ys: List<R>, f: (T, R) -> C): List<C> =
        zip(xs, ys).map { f(it.first, it.second) }

fun maxSum(xs: List<Int>) = zipWith(xs, xs.tail, { a, b -> a + b }).max()

fun <T> reverse(xs: List<T>) = reduce(mutableListOf<T>(), xs)
{ ys, s -> (s + ys).toMutableList() }

fun sumWithEvenIndexes(xs: List<Int>) =
        zip(xs, generateSequence(0) { it + 1 }.take(xs.size).toList())
                .filter { it.second % 2 == 0 }
                .map { it.first }
                .sum

fun <T> reduceSame(xs: List<T>) = reduce(mutableListOf<T>(), xs) { list, elem -> (list + elem).toMutableList() }