# プロパティ - 解答と解説

## 解答コード

```kotlin
class Thermostat {
    val history = mutableListOf<Double>()

    var temperature: Double = 0.0
        set(value) {
            if (value < 0) {
                println("Warning: Temperature below 0°C!")
            }
            field = value
            history.add(value)
            println("Temperature set to ${"%.1f".format(value)}°C (${"%.1f".format(fahrenheit)}°F)")
        }

    val fahrenheit: Double
        get() = temperature * 9.0 / 5.0 + 32.0
}

fun main() {
    val thermostat = Thermostat()
    val n = readLine()!!.toInt()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        thermostat.temperature = parts[2].toDouble()
    }

    println("Latest: ${"%.1f".format(thermostat.temperature)}°C")
    println("History: ${thermostat.history}")
}
```

## 解説

### カスタムgetter/setter
```kotlin
var name: String = ""
    get() = field.uppercase()  // カスタムgetter
    set(value) {               // カスタムsetter
        field = value.trim()
    }
```

### バッキングフィールド（field）
`field` はプロパティの実際の値を格納する場所：
- setter内で `this.name = value` と書くと無限再帰になる
- 代わりに `field = value` を使う

### 拡張プロパティ
既存クラスにプロパティを追加（バッキングフィールドなし）：
```kotlin
val String.wordCount: Int
    get() = this.split(" ").size
```

### 委譲プロパティ

**lazy（遅延初期化）：**
```kotlin
val heavyData: List<String> by lazy {
    // 最初のアクセス時にのみ実行
    loadData()
}
```

**observable（変更監視）：**
```kotlin
var count: Int by Delegates.observable(0) { _, old, new ->
    println("$old -> $new")
}
```

### ポイント
- カスタムgetter/setterで副作用（ログ、バリデーション）を追加できる
- `field` を使わないとStackOverflowErrorが発生する
- `by lazy` は重い初期化処理を遅延させるのに有効
