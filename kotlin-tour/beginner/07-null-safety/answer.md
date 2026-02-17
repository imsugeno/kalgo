# Null安全 - 解答と解説

## 解答コード

```kotlin
fun main() {
    val n = readLine()!!.toInt()
    val scores = mutableListOf<Int?>()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        val name: String? = if (parts[0] == "null") null else parts[0]
        val score: Int? = if (parts[1] == "null") null else parts[1].toInt()

        val displayName = name ?: "Unknown"
        val displayScore = score?.toString() ?: "N/A"
        println("$displayName: $displayScore")

        scores.add(score)
    }

    val validScores = scores.filterNotNull()
    println("Valid scores: ${validScores.count()}")
    println("Average score: ${validScores.average().toInt()}")
}
```

## 解説

### Nullable型
デフォルトでは null を代入できない。`?` を付けると許可：
```kotlin
var name: String = "Alice"   // null 不可
var name: String? = "Alice"  // null 可
name = null                  // OK
```

### 安全呼び出し演算子（`?.`）
null の場合は全体が null を返す：
```kotlin
val length: Int? = name?.length  // name が null なら null
```

チェーンも可能：
```kotlin
person?.company?.address?.city
```

### エルビス演算子（`?:`）
左辺が null の場合にデフォルト値を使用：
```kotlin
val displayName = name ?: "Unknown"  // name が null なら "Unknown"
val length = name?.length ?: 0       // 組み合わせも可能
```

### nullチェック
`if` で null チェックすると、その後のブロック内で自動的にnon-null型に推論される：
```kotlin
if (name != null) {
    println(name.length)  // ここでは String として扱える
}
```

### `filterNotNull()`
リストから null 要素を除去：
```kotlin
val list: List<Int?> = listOf(1, null, 3, null, 5)
val nonNulls: List<Int> = list.filterNotNull()  // [1, 3, 5]
```

### `toIntOrNull()`
文字列を Int に変換。変換できない場合は null：
```kotlin
"123".toIntOrNull()   // 123
"abc".toIntOrNull()   // null
```

### ポイント
- Kotlinのnull安全機能により、NullPointerExceptionをコンパイル時に防止できる
- `!!`（非null表明）の使用は最小限にし、`?.` と `?:` を活用する
