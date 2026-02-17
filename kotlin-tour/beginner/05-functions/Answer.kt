fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0): Int =
    ((hours * 60) + minutes) * 60 + seconds

fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        val parts = readLine()!!.split(" ").map { it.toInt() }
        println(intervalInSeconds(parts[0], parts[1], parts[2]))
    }
}
