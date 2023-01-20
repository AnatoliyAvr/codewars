package easyCyclistTraining

import kotlin.math.abs
import kotlin.math.atan
import kotlin.math.tan

const val GRAVITY_ACC = 9.81 * 3.6 * 60.0  // gravity acceleration
const val DRAG = 60.0 * 0.3 / 3.6          // force applied by air on the cyclist
const val DELTA_T = 1.0 / 60.0             // in minutes
const val G_THRUST = 60 * 3.6 * 3.6        // pedaling thrust
const val MASS = 80.0                      // biker's mass
const val WATTS0 = 225.0                   // initial biker's power
const val D_WATTS = 0.5                    // loss of power in W/mn

fun main() {
    println(temps(30.0, 5.0, 30.0)) // 114
    println(temps(30.0, 20.0, 30.0)) // -1
    println(temps(30.0, 8.0, 20.0)) // 110

}

fun temps(v0: Double, slope: Double, dTot: Double): Int {
    val gamma = GRAVITY_ACC * slope.degrees()

    val  air = DRAG * abs(v0) * abs(v0) / MASS

    G_THRUST * WATTS0 / (v0 * MASS)
    println(gamma)
    return Math.toDegrees(atan(slope / 100)).toInt()
}

fun Double.degrees() = Math.toDegrees(atan(this / 100.0))
