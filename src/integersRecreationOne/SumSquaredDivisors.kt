package integersRecreationOne

import kotlin.math.sqrt

fun main() {
    val start = System.currentTimeMillis()
    println(SumSquaredDivisors.listSquared(7602, 17900)) //[[9799, 96079204], [9855, 113635600]]
    println(SumSquaredDivisors.listSquared(29794, 38831)) //[[36531, 1514610724]]
    println(SumSquaredDivisors.listSquared(48626, 59122)) //[[57270, 4747210000]]
    println(SumSquaredDivisors.listSquared(97773, 105884)) //[]
    val end = System.currentTimeMillis()
    println(end - start)

//    val start = System.currentTimeMillis()
//    println(SumSquaredDivisors.listSquared(1, 250)) //[[1, 1], [42, 2500], [246, 84100]]
//    println(SumSquaredDivisors.listSquared(42, 250)) //[[42, 2500], [246, 84100]]
//    println(SumSquaredDivisors.listSquared(1, 10000))
//    //[[1, 1], [42, 2500], [246, 84100], [287, 84100], [728, 722500], [1434, 2856100], [1673, 2856100], [1880, 4884100], [4264, 24304900], [6237, 45024100], [9799, 96079204], [9855, 113635600]]
//    println(SumSquaredDivisors.listSquared(97773, 105884)) //[]
//    val end = System.currentTimeMillis()
//    println(end - start)

}

object SumSquaredDivisors {

    private val list = hashMapOf<Long, Long>()
    private var checkPosition = 0L

    fun listSquared(m: Long, n: Long): String {
        var result = ""
        getSqrt(m, n)
        checkPosition = n
        list.toSortedMap().forEach {
            result += "[${it.key}, ${it.value}], "
        }
        val res = "[$result]".trim()
        return if (res.length > 3) res.replaceRange(res.length - 3, res.length - 1, "").trim() else res
    }

    private fun getSqrt(m: Long, n: Long) {
        if (checkPosition < n) checkPosition = m else return
        for (i in checkPosition..n) {
            if (sqrt(sum(i).toDouble()) % 2 == 0.0 || i == 1L) {
                list[i] = sum(i)
            }
        }
    }

    private fun sum(m: Long): Long {
        val sum = mutableListOf<Long>()
        for (i in 1..m) {
            if (m % i == 0L) {
                sum.add(i * i)
            }
        }
        return sum.sum()
    }
}



