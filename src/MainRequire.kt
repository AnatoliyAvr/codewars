fun getIndices(count: Int): List<Int> {
    require(count >= 0) { "Count must be non-negative, was $count" }
//    // ...
    return List(count) { it + 1 }
}

// getIndices(-1) // will fail with IllegalArgumentException

fun main() {
    println(getIndices(1)) // [1, 2, 3]
}