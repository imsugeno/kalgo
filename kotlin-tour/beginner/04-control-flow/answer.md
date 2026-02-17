# 制御フロー - 解答と解説

## 解答コード

```kotlin
fun main() {
    val n = readLine()!!.toInt()

    for (i in 1..n) {
        val result = when {
            i % 15 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> "$i"
        }
        println(result)
    }
}
```

## 解説

### if/else
Kotlinでは `if` を式として使える（値を返せる）：
```kotlin
val max = if (a > b) a else b
```

### when 式
Kotlinの `when` は他言語の `switch` に相当するが、より強力：

**サブジェクト付き：**
```kotlin
when (value) {
    1 -> "one"
    2 -> "two"
    else -> "other"
}
```

**サブジェクトなし（ブーリアン条件）：**
```kotlin
when {
    x > 0 -> "positive"
    x < 0 -> "negative"
    else -> "zero"
}
```

### レンジ
| 構文 | 説明 | 例 |
|---|---|---|
| `1..5` | 1〜5（両端含む） | 1, 2, 3, 4, 5 |
| `1..<5` | 1〜4（右端除外） | 1, 2, 3, 4 |
| `5 downTo 1` | 逆順 | 5, 4, 3, 2, 1 |
| `1..10 step 2` | ステップ指定 | 1, 3, 5, 7, 9 |

### for ループ
```kotlin
for (i in 1..n) { ... }           // 1からnまで
for (item in collection) { ... }   // コレクションの要素
```

### while ループ
```kotlin
while (条件) { ... }        // 条件が真の間繰り返す
do { ... } while (条件)     // 最低1回は実行
```

### ポイント
- `when` の分岐は上から順に評価される → 15の倍数チェックを最初にする必要がある
- `when` を式として使う場合、`else` ブランチは必須
