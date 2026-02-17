// ConversionCounter: 変換回数を追跡するシングルトン
// TODO: object 宣言で実装してください

// Temperature: データクラス（摂氏を保持）
// companion object で fromFahrenheit ファクトリメソッドを実装
// TODO: ここにコードを書いてください

fun main() {
    val n = readLine()!!.toInt()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        val unit = parts[0]
        val value = parts[1].toDouble()

        // celsius → 華氏に変換して出力
        // fahrenheit → 摂氏に変換して出力（companion object のファクトリメソッド使用）
        // 変換のたびに ConversionCounter をインクリメント
        // TODO: ここにコードを書いてください
    }

    // 変換回数を出力
    // TODO: ここにコードを書いてください
}
