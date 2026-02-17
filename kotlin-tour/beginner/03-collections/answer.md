# コレクション - 解答と解説

## 解答コード

```kotlin
fun main() {
    val n = readLine()!!.toInt()
    val fruits = readLine()!!.split(" ")
    val searchFruit = readLine()!!

    println("List: $fruits")
    println("Count: ${fruits.count()}")
    println("First: ${fruits.first()}")
    println("Last: ${fruits.last()}")

    val uniqueFruits = fruits.toSet()
    println("Unique: ${uniqueFruits.toList()}")
    println("Unique count: ${uniqueFruits.count()}")
    println("$searchFruit found: ${searchFruit in fruits}")
}
```

## 解説

### List（リスト）
- `listOf()`: 読み取り専用リスト
- `mutableListOf()`: 変更可能なリスト
- 順序付き、重複許可
- `[index]` でインデックスアクセス
- `.first()`, `.last()`, `.count()` で操作

### Set（セット）
- `setOf()`: 読み取り専用セット
- `mutableSetOf()`: 変更可能なセット
- 重複要素を自動除去
- `.toSet()` でリストからセットに変換

### Map（マップ）
- `mapOf("key" to value)`: 読み取り専用マップ
- `mutableMapOf()`: 変更可能なマップ
- キーは一意、`[key]` でアクセス

### in 演算子
- `element in collection` で要素の存在確認
- `containsKey()`, `containsValue()` も使用可能（Map）

### ミュータブル vs イミュータブル
- 読み取り専用（`listOf`, `setOf`, `mapOf`）を優先して使う
- 変更が必要な場合のみ `mutableListOf` 等を使う
