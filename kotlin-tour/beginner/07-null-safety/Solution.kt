fun main() {
    val n = readLine()!!.toInt()
    val scores = mutableListOf<Int?>()

    repeat(n) {
        val parts = readLine()!!.split(" ")

        // "null" という文字列を実際の null に変換
        // TODO: name を nullable な String? として取得してください

        // TODO: score を nullable な Int? として取得してください

        // エルビス演算子を使ってデフォルト値を設定
        // name が null → "Unknown", score が null → "N/A"
        // TODO: ここにコードを書いてください

        // "[名前]: [スコア]" の形式で出力
        // TODO: ここにコードを書いてください

        scores.add(score)
    }

    // null以外のスコアをフィルタして集計
    // TODO: validScores を filterNotNull() で取得してください

    // "Valid scores: [数]" を出力
    // TODO: ここにコードを書いてください

    // "Average score: [平均（整数）]" を出力
    // TODO: ここにコードを書いてください
}
