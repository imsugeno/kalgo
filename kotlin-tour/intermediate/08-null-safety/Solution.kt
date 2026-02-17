data class StudentRecord(val name: String?, val score: Int?, val subject: String?)

// レコード文字列をパースする関数
// "null" 文字列を実際の null に変換（takeIf を活用）
// TODO: parseRecord 関数を実装してください

// レコードをフォーマットする関数
// 全てnull → null を返す
// スコアあり → "[名前] scored [スコア] in [科目]"
// スコアなし → "[名前]: score not available for [科目]"
// TODO: formatRecord 関数を実装してください

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
