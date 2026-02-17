# Openクラスと特殊クラス - 解答と解説

## 解答コード

```kotlin
enum class Color { RED, GREEN, BLUE }

sealed class Command {
    data class Move(val x: Int, val y: Int) : Command()
    data class Draw(val shape: String, val color: Color) : Command()
    data object Stop : Command()
}

fun parseCommand(line: String): Command {
    val parts = line.split(" ")
    return when (parts[0]) {
        "MOVE" -> Command.Move(parts[1].toInt(), parts[2].toInt())
        "DRAW" -> Command.Draw(parts[1], Color.valueOf(parts[2]))
        "STOP" -> Command.Stop
        else -> throw IllegalArgumentException("Unknown command: ${parts[0]}")
    }
}

fun executeCommand(command: Command): String = when (command) {
    is Command.Move -> "Moving to (${command.x}, ${command.y})"
    is Command.Draw -> "Drawing ${command.color} ${command.shape}"
    is Command.Stop -> "Stopped"
}

fun main() {
    val n = readLine()!!.toInt()
    val commands = List(n) { parseCommand(readLine()!!) }

    commands.forEach { println(executeCommand(it)) }

    println("Commands executed: ${commands.size}")
    println("Move commands: ${commands.count { it is Command.Move }}")
    println("Draw commands: ${commands.count { it is Command.Draw }}")
}
```

## 解説

### sealed class
継承を同一パッケージ内に制限する特殊なクラス：
```kotlin
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
}
```
- `when` 式で全サブタイプを網羅すると `else` が不要
- コンパイラが全ケースのカバーを検証

### enum class
有限の定数値を定義：
```kotlin
enum class Direction { NORTH, SOUTH, EAST, WEST }

// プロパティ付き
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
```

### open class
継承を許可するクラス（デフォルトでは final）：
```kotlin
open class Vehicle(val make: String) {
    open fun displayInfo() { println(make) }
}
class Car(make: String) : Vehicle(make) {
    override fun displayInfo() { println("Car: $make") }
}
```

### inline value class
パフォーマンス最適化用の軽量クラス：
```kotlin
@JvmInline
value class Email(val address: String)
```

### ポイント
- `sealed class` + `when` はパターンマッチングの強力なパターン
- `enum` は有限な状態を表現するのに最適
- `is` 演算子でスマートキャストが行われる
