package reverse_or_rotate

import kotlin.math.pow

fun main() {
    var s = "733049910872815764" //73304 99108 72815 764
    println(revRot(s, 5)) //, "33047 91089 28157")
    s = "73304991087281576455176044327690580265896"
    println(revRot(s, 8)) //, "1994033775182780067155464327690480265895")
    s = "73304991087281576455176044327690580265896896028"
    println(revRot(s, 8)) //, "1994033775182780067155464327690480265895")
}

fun revRot(nums: String, sz: Int): String {

    val list = nums.chunked(sz)
    val result = mutableListOf<String>()

    var sum = 0.0

    for (i in 0 until list.size - 1) {
        if (list[i].length == sz) {
            for (j in 0 until sz) {
                sum += list[i][j].toString().toDouble().pow(3.0)
            }
        }
        if (sum % 2.0 == 0.0) {
            result.add(list[i].reversed())
        } else {
            result.add(firstReverseTry(list[i].toList()).joinToString(""))

        }
        sum = 0.0
    }
    return result.joinToString("")
}

fun <T> firstReverseTry(arr: List<T>): List<T> {
    val result = arr.toMutableList()

    if (arr.size > 1) {
        result.add(arr[0])
        result.removeAt(0)
    }
    return result
}

/*
Входные данные представляют собой строку, состоящую из цифр. Разрежьте строку на фрагменты
(фрагмент здесь является подстрокой начальной строки) размером sz (игнорируйте последний фрагмент,
если его размер меньше sz).

Если фрагмент представляет собой целое число, например, сумма кубов его цифр делится на 2,
переверните этот фрагмент; в противном случае поверните его влево на одну позицию. Соберите
вместе эти измененные фрагменты и верните результат в виде строки.

Если

sz равен <= 0 или, если str пуст, возвращает ""
sz больше (>), чем длина str, невозможно взять фрагмент размера sz, следовательно, возвращает
* */