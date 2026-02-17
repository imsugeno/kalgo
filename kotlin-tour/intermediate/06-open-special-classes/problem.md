# Openクラスと特殊クラス

## 学習テーマ
- `open` クラス（継承可能なクラス）
- `sealed` クラス（制限された型階層）
- `enum` クラス（定数の列挙）
- `when` 式との組み合わせ

## 問題

描画コマンドを処理するプログラムを作成してください。

`sealed class` でコマンドの型階層を定義し、`enum class` で色を管理します。

### コマンド定義
- `MOVE x y` → 座標 (x, y) に移動
- `DRAW shape color` → 指定された色で図形を描画（shape: circle/rectangle, color: RED/GREEN/BLUE）
- `STOP` → 停止

### 入力形式
```
N（コマンド数）
コマンド1
コマンド2
...
```

### 出力形式
各コマンドの結果を1行ずつ出力し、最後にサマリーを出力

### 入出力例

**入力:**
```
5
MOVE 10 20
DRAW circle RED
MOVE 30 40
DRAW rectangle BLUE
STOP
```

**出力:**
```
Moving to (10, 20)
Drawing RED circle
Moving to (30, 40)
Drawing BLUE rectangle
Stopped
Commands executed: 5
Move commands: 2
Draw commands: 2
```

## ヒント
- `sealed class` のサブクラスは同じパッケージ内でのみ定義可能
- `when` 式で `sealed class` を使うと、すべてのケースをカバーしているか検証される
- `enum class` は `valueOf()` で文字列から変換可能
