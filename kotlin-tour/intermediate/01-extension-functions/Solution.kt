// 拡張関数1: 文字列の単語数を返す
// TODO: String.wordCount() を実装してください

// 拡張関数2: 回文判定（大文字小文字無視、スペース除去）
// TODO: String.isPalindrome() を実装してください

// 拡張関数3: 階乗を計算する
// TODO: Int.factorial() を実装してください

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
