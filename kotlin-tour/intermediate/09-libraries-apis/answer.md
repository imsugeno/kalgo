# ライブラリとAPI - 解答と解説

## 解答コード

```kotlin
fun getGrade(score: Int): String = when {
    score >= 90 -> "A"
    score >= 80 -> "B"
    score >= 70 -> "C"
    score >= 60 -> "D"
    else -> "F"
}

fun main() {
    val n = readLine()!!.toInt()
    val scores = readLine()!!.split(" ").map { it.toInt() }

    println("Scores: $scores")
    println("Sorted: ${scores.sorted()}")

    val average = scores.average()
    println("Average: ${"%.1f".format(average)}")
    println("Max: ${scores.max()}")
    println("Min: ${scores.min()}")

    val aboveAverage = scores.filter { it >= average }
    println("Above average: $aboveAverage")

    val gradeDistribution = scores.groupBy { getGrade(it) }
        .mapValues { it.value.size }
    println("Grade distribution: $gradeDistribution")
}
```

## 解説

### コレクション操作
Kotlin標準ライブラリには豊富なコレクション操作がある：

**変換:**
```kotlin
list.map { it * 2 }           // 各要素を変換
list.mapNotNull { ... }       // 変換してnull除去
list.flatMap { ... }          // 変換して平坦化
```

**フィルタリング:**
```kotlin
list.filter { it > 0 }        // 条件に合う要素
list.filterNot { it > 0 }     // 条件に合わない要素
list.filterNotNull()           // null除去
```

**ソート:**
```kotlin
list.sorted()                  // 昇順ソート
list.sortedDescending()        // 降順ソート
list.sortedBy { it.name }     // プロパティでソート
```

**集約:**
```kotlin
list.sum()                     // 合計
list.average()                 // 平均
list.max() / list.min()       // 最大/最小
list.count()                   // 個数
list.sumOf { it.score }       // 特定の値の合計
```

**グループ化:**
```kotlin
list.groupBy { getGrade(it) }  // グレードでグループ化
    .mapValues { it.value.size } // 各グループの人数
```

### 文字列操作
```kotlin
"hello".uppercase()        // "HELLO"
"HELLO".lowercase()        // "hello"
"hello".reversed()         // "olleh"
"hello".replaceFirstChar { it.uppercase() }  // "Hello"
```

### kotlin.math
```kotlin
import kotlin.math.*
PI                 // 3.141592653589793
abs(-5)            // 5
sqrt(16.0)         // 4.0
max(a, b)          // 大きい方
```

### ポイント
- 標準ライブラリの関数を使うことで、ループを書かずにデータ処理ができる
- メソッドチェーンで処理を連結すると可読性が高い
- `groupBy` + `mapValues` の組み合わせは頻出パターン
