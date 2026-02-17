# レシーバ付きラムダ式

## 学習テーマ
- レシーバ付きラムダの型: `ReceiverType.() -> ReturnType`
- DSL（ドメイン固有言語）パターン
- `buildString`, `buildList` の仕組み

## 問題

簡易HTMLビルダーを作成してください。
レシーバ付きラムダを使って、DSL風のAPIでHTMLを生成します。

### 入力形式
```
タイトル
段落数
段落1のテキスト
段落2のテキスト
...
```

### 出力形式
```
<html>
  <head>[タイトル]</head>
  <body>
    <p>[段落1]</p>
    <p>[段落2]</p>
    ...
  </body>
</html>
```

### 入出力例

**入力:**
```
My Page
3
Hello World
Kotlin is awesome
Have fun!
```

**出力:**
```
<html>
  <head>My Page</head>
  <body>
    <p>Hello World</p>
    <p>Kotlin is awesome</p>
    <p>Have fun!</p>
  </body>
</html>
```

## ヒント
- `buildString { append(...) }` でレシーバ付きラムダを体験できます
- HTMLビルダークラスを作成し、`html { }`, `body { }` のようなDSLを設計しましょう
- レシーバ付きラムダの型: `StringBuilder.() -> Unit`
