fun main() {
    val n = readLine()!!.toInt()

    for (i in 1..n) {
        val result = when {
            i % 15 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> "$i"
        }
        println(result)
    }
}
