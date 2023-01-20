fun main() {
    val code = "400-763"

    when (code) {
        Code.WRONG_REGISTER_CODE -> println(400)
        Code.WRONG_REGISTER_CODE_SIGNUP_2 -> println("400-763")
        else -> println("else")
    }
}

object Code {
    const val WRONG_REGISTER_CODE = "400"
    const val WRONG_REGISTER_CODE_SIGNUP_2 = "400-763"
}