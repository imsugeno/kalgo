data class StudentRecord(val name: String?, val score: Int?, val subject: String?)

fun parseRecord(line: String): StudentRecord {
    val parts = line.split(" ")
    return StudentRecord(
        name = parts[0].takeIf { it != "null" },
        score = parts[1].takeIf { it != "null" }?.toInt(),
        subject = parts[2].takeIf { it != "null" }
    )
}

fun formatRecord(record: StudentRecord): String? {
    val (name, score, subject) = record

    if (name == null && score == null && subject == null) return null

    val displayName = name ?: "Unknown"
    val displaySubject = subject ?: "Unknown Subject"

    return if (score != null) {
        "$displayName scored $score in $displaySubject"
    } else {
        "$displayName: score not available for $displaySubject"
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val records = List(n) { parseRecord(readLine()!!) }

    val validScores = mutableListOf<Int>()

    records.forEach { record ->
        val formatted = formatRecord(record)
        if (formatted != null) {
            println(formatted)
            record.score?.let { validScores.add(it) }
        } else {
            println("Invalid record skipped")
        }
    }

    println("Valid records: ${validScores.size}")
    if (validScores.isNotEmpty()) {
        println("Average score: ${validScores.average().toInt()}")
    }
}
