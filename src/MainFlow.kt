import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

suspend fun main() {
    //getUsers().collect { user -> println(user) }
    //getNumbers().collect { number -> println(number) }
//    flowOf("A", "B", "C")
//        .onEach  { println("1$it") }
//        .buffer()  // <--------------- buffer between onEach and collect
//        .collect { println("2$it") }
    val nums = (1..3).asFlow()
    val strs = flowOf("one", "two", "three")
    val strs1 = flowOf("one", "two", "three")
    nums.zip(strs) { a, b -> "$a -> $b" }.collect { println(it) }
}

fun getUsers(): Flow<String> = flow {
    val database = listOf("Tom", "Bob", "Sam")  // условная база данных
    var i = 1;
    for (item in database) {
        delay(400L) // имитация продолжительной работы
        println("Emit $i item")
        emit(item) // емитируем значение
        i++
    }
}

fun getNumbers(): Flow<Int> = flow {
    for (item in 1..5) {
        emit(item * item)
    }
}