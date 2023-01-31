package incomplete_virus

fun main() {
    println("7 - " + Kata.incompleteVirus("7")) // 1)
    println("10 - " + Kata.incompleteVirus("10")) // 2)
    println("15 - " + Kata.incompleteVirus("15")) // 3)
    println("20 - " + Kata.incompleteVirus("20")) //3)
    println("72 - " + Kata.incompleteVirus("72")) //3)
    println("99 - " + Kata.incompleteVirus("99")) //3)
    println("100 - " + Kata.incompleteVirus("100")) //4)
    println("101 - " + Kata.incompleteVirus("101")) //5)
    println("102 - " + Kata.incompleteVirus("102")) //5)
    println("1000 - " + Kata.incompleteVirus("1000")) //8)
    println("1011 - " + Kata.incompleteVirus("1011")) //11)
    println("2011 - " + Kata.incompleteVirus("2011")) //15)
    println("1000000 - " + Kata.incompleteVirus("1000000")) //64)
    println("10000000 - " + Kata.incompleteVirus("10000000")) //128)
    println("100000000 - " + Kata.incompleteVirus("100000000")) //256)
    println("1000000000 - " + Kata.incompleteVirus("1000000000")) //512)
    println("1000000000000000000 - " + Kata.incompleteVirus("1000000000000000000")) //262144)
    println("418317474741968765734786225772457234 - " + Kata.incompleteVirus("418317474741968765734786225772457234")) //262144)
}

object Kata {

    fun incompleteVirus(s: String): Long {
        var cond = false
        var sMod = ""
        s.forEach {
            if (it.toString().toInt() > 1) cond = true
            sMod += if (cond) "1" else it
        }
        return sMod.toLong(2)
    }

    private fun a(start: Long, end: Long): Long {
        var count = 0L
        for (i in start..end) {
            if (i.toString().first().toString() == "1") {
                if (b(i.toString())) {
                    count++
                }
            }
        }
        return count
    }

    private fun b(s: String): Boolean {
        val list = mutableListOf<Int>()
        s.forEach {
            if (it.toString() == "1" || it.toString() == "0") {
                list.add(1)
            } else {
                return false
            }
        }
        if (s.length == list.size) return true
        return false
    }
}