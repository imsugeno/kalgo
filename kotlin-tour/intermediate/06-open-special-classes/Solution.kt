// Color enum クラスを定義（RED, GREEN, BLUE）
// TODO: ここにコードを書いてください

// Command sealed クラスを定義
// - Move(x: Int, y: Int)
// - Draw(shape: String, color: Color)
// - Stop
// TODO: ここにコードを書いてください

// コマンド文字列をパースする関数
// TODO: parseCommand 関数を実装してください

// コマンドを実行して結果文字列を返す関数
// when 式を使って sealed class のパターンマッチング
// TODO: executeCommand 関数を実装してください

fun main() {
    val n = readLine()!!.toInt()
    val commands = List(n) { parseCommand(readLine()!!) }

    commands.forEach { println(executeCommand(it)) }

    println("Commands executed: ${commands.size}")
    println("Move commands: ${commands.count { it is Command.Move }}")
    println("Draw commands: ${commands.count { it is Command.Draw }}")
}
