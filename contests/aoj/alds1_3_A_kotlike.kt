import java.util.ArrayDeque

fun main() {
    // 標準のArrayDequeを使用（高速で、スタックとして振る舞えます）
    val stack = ArrayDeque<Int>()

    // 入力を読み込み、空白で分割して処理
    val input = readln().split(" ")

    for (x in input) {
        when (x) {
            "+", "-", "*" -> {
                // pop()はJavaのDequeメソッド。空の場合は例外を投げるので安全
                val b = stack.pop() // 先にpopされるのが右辺値
                val a = stack.pop()

                // 式の結果をwhenから直接返す＆pushする
                val result = when (x) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    else -> error("Unknown operator") // 到達不能だが安全性のため
                }
                stack.push(result)
            }
            // 数値の場合は変換してpush
            else -> stack.push(x.toInt())
        }
    }

    println(stack.pop())
}