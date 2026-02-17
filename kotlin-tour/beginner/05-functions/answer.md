# 関数 - 解答と解説

## 解答コード

```kotlin
fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0): Int =
    ((hours * 60) + minutes) * 60 + seconds

fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        val parts = readLine()!!.split(" ").map { it.toInt() }
        println(intervalInSeconds(parts[0], parts[1], parts[2]))
    }
}
```

## 解説

### 関数の宣言
```kotlin
fun 関数名(引数: 型): 戻り値の型 {
    return 結果
}
```

### デフォルト引数
引数にデフォルト値を設定可能：
```kotlin
fun greet(name: String, prefix: String = "Hello") {
    println("$prefix, $name!")
}
greet("Alice")                // Hello, Alice!
greet("Alice", "Hi")          // Hi, Alice!
```

### 名前付き引数
引数名を指定して呼び出し可能（順序不問）：
```kotlin
intervalInSeconds(minutes = 10)       // 600
intervalInSeconds(hours = 1, seconds = 1)  // 3601
```

### 単一式関数
本体が1つの式のみの場合、波括弧を省略できる：
```kotlin
// 通常
fun sum(x: Int, y: Int): Int {
    return x + y
}

// 単一式関数
fun sum(x: Int, y: Int) = x + y
```

### ラムダ式
名前のない関数をラムダ式で記述：
```kotlin
val double = { x: Int -> x * 2 }
println(double(5))  // 10

// コレクション操作でよく使う
val numbers = listOf(1, 2, 3)
val doubled = numbers.map { it * 2 }  // [2, 4, 6]
```

### 関数型
ラムダの型は `(引数型) -> 戻り値型` で表す：
```kotlin
val operation: (Int, Int) -> Int = { a, b -> a + b }
```

### トレイリングラムダ
最後の引数がラムダの場合、括弧の外に記述可能：
```kotlin
listOf(1, 2, 3).fold(0) { acc, item -> acc + item }
```
