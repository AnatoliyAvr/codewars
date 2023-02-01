package eulerMethod

import kotlin.math.E
import kotlin.math.abs
import kotlin.math.pow

fun main() {
    println(EulerOde.exEuler(1)) //0.5
    println(EulerOde.exEuler(10)) //0.026314
    println(EulerOde.exEuler(17)) //0.015193
}

//object EulerOde {
//
//    fun exEuler(nb: Int): Double {
//        return 1 + (0.5 * 10).pow(-4.0 * 10) - (0.5 * 10).pow(-2.0 * 10)
//    }
//    //z=1+0.5e−4x−0.5e−2x
//}


object EulerOde {

    fun exEuler(nb: Int): Double {
        val errors = DoubleArray(nb + 1)
        //Conditions:
        val h = 1.0 / nb
        val x0 = 0.0
        val y0 = 1.0
        val f0 = computeF(x0, y0)
        errors[0] = computeError(x0, y0)

        var fPrevious = f0
        var yPrevious = y0

        for (i in 1..nb) {
            val xi = h * i
            val yi = yPrevious + h * fPrevious
            fPrevious = computeF(xi, yi)
            yPrevious = yi
            errors[i] = computeError(xi, yi)
        }

        return errors.average()
    }

    private fun computeF(x: Double, y: Double) = 2 - E.pow(-4 * x) - 2 * y

    private fun computeError(x: Double, y: Double): Double {
        val z = 1 + 0.5 * E.pow(-4 * x) - 0.5 * E.pow(-2 * x)
        return abs(y - z) / z
    }
}
