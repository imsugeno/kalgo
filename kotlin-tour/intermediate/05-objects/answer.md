# オブジェクト - 解答と解説

## 解答コード

```kotlin
object ConversionCounter {
    var count = 0
    fun increment() { count++ }
}

data class Temperature(val celsius: Double) {
    val fahrenheit: Double get() = celsius * 9.0 / 5.0 + 32.0

    companion object {
        fun fromFahrenheit(f: Double): Temperature =
            Temperature((f - 32.0) * 5.0 / 9.0)
    }
}

fun main() {
    val n = readLine()!!.toInt()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        val unit = parts[0]
        val value = parts[1].toDouble()

        when (unit) {
            "celsius" -> {
                val temp = Temperature(value)
                ConversionCounter.increment()
                println("${"%.1f".format(value)}°C = ${"%.1f".format(temp.fahrenheit)}°F")
            }
            "fahrenheit" -> {
                val temp = Temperature.fromFahrenheit(value)
                ConversionCounter.increment()
                println("${"%.1f".format(value)}°F = ${"%.1f".format(temp.celsius)}°C")
            }
        }
    }

    println("Conversions performed: ${ConversionCounter.count}")
}
```

## 解説

### object 宣言（シングルトン）
唯一のインスタンスを持つクラス。`object` キーワードで宣言と作成を同時に行う：
```kotlin
object DatabaseConfig {
    val url = "jdbc:..."
    fun connect() { ... }
}
DatabaseConfig.connect()  // クラス名で直接アクセス
```
- 遅延初期化（最初のアクセス時に生成）
- スレッドセーフ

### companion object
クラス内の共有オブジェクト。ファクトリメソッドによく使われる：
```kotlin
data class User(val name: String, val id: Int) {
    companion object {
        fun create(name: String): User = User(name, nextId++)
        private var nextId = 1
    }
}
val user = User.create("Alice")  // クラス名.メソッド名 でアクセス
```

### data object
`toString()` と `equals()` が自動生成される object：
```kotlin
data object AppConfig {
    var version = "1.0"
}
println(AppConfig)  // "AppConfig"（クラス名が出力される）
```

### object vs companion object
| 特徴 | object | companion object |
|---|---|---|
| スコープ | トップレベル | クラス内 |
| アクセス | オブジェクト名 | クラス名 |
| 用途 | シングルトン | ファクトリ、定数 |
