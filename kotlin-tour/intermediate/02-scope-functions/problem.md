# スコープ関数

## 学習テーマ
- `let`: null安全な操作、ラムダの結果を返す
- `apply`: オブジェクトの初期化、オブジェクト自体を返す
- `run`: 初期化 + 結果の計算
- `also`: 副作用（ログ出力等）、オブジェクト自体を返す
- `with`: オブジェクトに対する複数操作

## 問題

ユーザー情報を管理するプログラムを作成してください。
スコープ関数を活用して、以下の処理を行ってください。

### 入力形式
```
名前
メールアドレス
年齢
```

### 出力形式
```
Creating user: [名前]
User(name=[名前], email=[メールアドレス], age=[年齢])
Name length: [名前の文字数]
Updated email: [名前の小文字]_updated@example.com
```

### 入出力例

**入力:**
```
John
john@example.com
25
```

**出力:**
```
Creating user: John
User(name=John, email=john@example.com, age=25)
Name length: 4
Updated email: john_updated@example.com
```

## ヒント
- `also` はログ出力などの副作用に最適
- `apply` はオブジェクト初期化に最適
- `let` で変換処理、`run` で複数操作+結果取得
- `with` でオブジェクトの複数プロパティにアクセス

### スコープ関数の使い分け
| 関数 | アクセス | 戻り値 | 用途 |
|---|---|---|---|
| `let` | `it` | ラムダ結果 | null安全操作 |
| `apply` | `this` | オブジェクト | 初期化 |
| `run` | `this` | ラムダ結果 | 初期化+計算 |
| `also` | `it` | オブジェクト | 副作用 |
| `with` | `this` | ラムダ結果 | 複数操作 |
