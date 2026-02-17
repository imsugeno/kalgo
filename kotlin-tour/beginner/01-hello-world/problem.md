# 変数と文字列テンプレート

## 学習テーマ
- `val`（読み取り専用）と `var`（変更可能）の変数宣言
- 文字列テンプレート（`$variable` と `${expression}`）
- `println()` による出力

## 問題

標準入力から名前（String）と年齢（Int）を読み取り、以下のフォーマットで出力してください。

### 入力形式
```
名前
年齢
```

### 出力形式
```
Hello, [名前]!
You are [年齢] years old.
Next year, you will be [年齢+1] years old.
```

### 入出力例

**入力:**
```
Taro
25
```

**出力:**
```
Hello, Taro!
You are 25 years old.
Next year, you will be 26 years old.
```

## ヒント
- `readLine()` で標準入力から1行読み取れます
- `toInt()` で文字列を整数に変換できます
- 文字列テンプレート `${expression}` で式の結果を埋め込めます
