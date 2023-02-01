package firstReverseTry


fun main() {
    println(firstReverseTry(intArrayOf(1, 2, 3, 4, 5)).toList()) //5,2,3,4,1
    println(firstReverseTry(intArrayOf()).toList()) //
    println(firstReverseTry(intArrayOf(111)).toList()) //111
    println(firstReverseTry(intArrayOf(23, 54, 12, 3, 4, 56, 23, 12, 5, 324)).toList()) //324, 54, 12, 3, 4, 56, 23, 12, 5, 23
    println(firstReverseTry(intArrayOf(-1, 1)).toList()) //1,-1
}

fun firstReverseTry(arr: IntArray): IntArray {
    val result = arr.toMutableList()

    if (arr.size > 1) {
        result[arr.lastIndex] = arr[0]
        result[0] = arr[arr.lastIndex]
    }

    return result.toIntArray()
}