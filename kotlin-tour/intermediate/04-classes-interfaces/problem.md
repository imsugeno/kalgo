# クラスとインターフェース

## 学習テーマ
- インターフェースの定義と実装
- 抽象クラス
- `override` キーワード
- ポリモーフィズム（多態性）
- 複数インターフェースの実装

## 問題

図形の面積と周囲長を計算するプログラムを作成してください。

`Shape` インターフェースを定義し、`Circle` と `Rectangle` クラスで実装してください。

### インターフェース
```kotlin
interface Shape {
    fun area(): Double
    fun perimeter(): Double
    fun describe(): String
}
```

### 入力形式
```
N（図形の数）
種類 引数...
```
- `circle 半径`
- `rectangle 幅 高さ`

### 出力形式
```
[describe()の結果]: area=[面積], perimeter=[周囲長]
（N行繰り返し）
Total area: [全図形の面積の合計]
```
※ 数値は小数点以下2桁で出力（`"%.2f".format()`を使用）

### 入出力例

**入力:**
```
3
circle 5.0
rectangle 4.0 6.0
circle 3.0
```

**出力:**
```
Circle(r=5.0): area=78.54, perimeter=31.42
Rectangle(w=4.0, h=6.0): area=24.00, perimeter=20.00
Circle(r=3.0): area=28.27, perimeter=18.85
Total area: 130.81
```

## ヒント
- `kotlin.math.PI` で円周率を使用
- `"%.2f".format(value)` で小数点2桁にフォーマット
- ポリモーフィズム: `List<Shape>` に異なる型のオブジェクトを格納可能
