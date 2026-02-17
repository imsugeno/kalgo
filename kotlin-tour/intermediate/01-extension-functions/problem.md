# 拡張関数

## 学習テーマ
- 拡張関数の定義方法（`fun ClassName.functionName()`）
- レシーバ（`this`）へのアクセス
- 既存クラスへの機能追加

## 問題

以下の拡張関数を実装し、標準入力から文字列を読み取って処理してください。

1. `String.wordCount(): Int` — 文字列の単語数を返す
2. `String.isPalindrome(): Boolean` — 回文かどうかを判定する（大文字小文字無視、空白除去）
3. `Int.factorial(): Long` — 階乗を計算する

### 入力形式
```
N（クエリ数）
クエリの種類 引数
```
- `words [文字列]` → 単語数を出力
- `palindrome [文字列]` → 回文判定を出力
- `factorial [整数]` → 階乗を出力

### 出力形式
各クエリの結果を1行ずつ

### 入出力例

**入力:**
```
5
words Hello World
words Kotlin is awesome
palindrome racecar
palindrome hello
factorial 5
```

**出力:**
```
2
3
true
false
120
```

## ヒント
- `this` で拡張関数のレシーバ（呼び出し元のオブジェクト）にアクセスできます
- `split(" ")` で文字列をスペースで分割
- `reversed()` で文字列を反転
- `lowercase()` で小文字に変換
