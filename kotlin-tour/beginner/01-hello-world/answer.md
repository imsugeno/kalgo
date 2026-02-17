# 変数と文字列テンプレート - 解答と解説

## 解答コード

```kotlin
fun main() {
    val name = readLine()!!
    val age = readLine()!!.toInt()

    println("Hello, $name!")
    println("You are $age years old.")
    println("Next year, you will be ${age + 1} years old.")
}
```

## 解説

### val と var
- `val`（value）: 読み取り専用の変数。一度代入したら変更不可
- `var`（variable）: 変更可能な変数。再代入が可能
- 今回の問題では値を変更する必要がないため `val` を使用

### 文字列テンプレート
- `$name` のように `$変数名` で変数の値を文字列に埋め込める
- `${age + 1}` のように `${式}` で式の結果を埋め込める
- 文字列連結（`+`）よりも可読性が高く、Kotlinでは推奨される書き方

### readLine()
- 標準入力から1行読み取る関数
- 戻り値は `String?`（null の可能性あり）
- `!!` は非null表明演算子で、nullの場合は例外をスロー
- `toInt()` で文字列を Int に変換

### ポイント
- Kotlinではすべての変数をまず `val` で宣言し、必要な場合のみ `var` を使うのがベストプラクティス
- 型推論により、`val name = readLine()!!` で自動的に `String` 型と推論される
