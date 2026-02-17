fun main() {
    val n = readLine()!!.toInt()
    val scores = mutableListOf<Int?>()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        val name: String? = if (parts[0] == "null") null else parts[0]
        val score: Int? = if (parts[1] == "null") null else parts[1].toInt()

        val displayName = name ?: "Unknown"
        val displayScore = score?.toString() ?: "N/A"
        println("$displayName: $displayScore")

        scores.add(score)
    }

    val validScores = scores.filterNotNull()
    println("Valid scores: ${validScores.count()}")
    println("Average score: ${validScores.average().toInt()}")
}
