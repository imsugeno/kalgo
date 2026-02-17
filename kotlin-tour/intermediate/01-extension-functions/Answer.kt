fun String.wordCount(): Int = this.split(" ").count()

fun String.isPalindrome(): Boolean {
    val cleaned = this.lowercase().replace(" ", "")
    return cleaned == cleaned.reversed()
}

fun Int.factorial(): Long {
    var result = 1L
    for (i in 1..this) {
        result *= i
    }
    return result
}

fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        val line = readLine()!!
        val spaceIndex = line.indexOf(' ')
        val command = line.substring(0, spaceIndex)
        val arg = line.substring(spaceIndex + 1)

        when (command) {
            "words" -> println(arg.wordCount())
            "palindrome" -> println(arg.isPalindrome())
            "factorial" -> println(arg.toInt().factorial())
        }
    }
}
