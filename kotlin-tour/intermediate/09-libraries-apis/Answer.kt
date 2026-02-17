fun getGrade(score: Int): String = when {
    score >= 90 -> "A"
    score >= 80 -> "B"
    score >= 70 -> "C"
    score >= 60 -> "D"
    else -> "F"
}

fun main() {
    val n = readLine()!!.toInt()
    val scores = readLine()!!.split(" ").map { it.toInt() }

    println("Scores: $scores")
    println("Sorted: ${scores.sorted()}")

    val average = scores.average()
    println("Average: ${"%.1f".format(average)}")
    println("Max: ${scores.max()}")
    println("Min: ${scores.min()}")

    val aboveAverage = scores.filter { it >= average }
    println("Above average: $aboveAverage")

    val gradeDistribution = scores.groupBy { getGrade(it) }
        .mapValues { it.value.size }
    println("Grade distribution: $gradeDistribution")
}
