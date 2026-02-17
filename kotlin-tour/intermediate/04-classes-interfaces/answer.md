# クラスとインターフェース - 解答と解説

## 解答コード

```kotlin
import kotlin.math.PI

interface Shape {
    fun area(): Double
    fun perimeter(): Double
    fun describe(): String
}

class Circle(val radius: Double) : Shape {
    override fun area(): Double = PI * radius * radius
    override fun perimeter(): Double = 2 * PI * radius
    override fun describe(): String = "Circle(r=$radius)"
}

class Rectangle(val width: Double, val height: Double) : Shape {
    override fun area(): Double = width * height
    override fun perimeter(): Double = 2 * (width + height)
    override fun describe(): String = "Rectangle(w=$width, h=$height)"
}

fun main() {
    val n = readLine()!!.toInt()
    val shapes = mutableListOf<Shape>()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        val shape: Shape = when (parts[0]) {
            "circle" -> Circle(parts[1].toDouble())
            "rectangle" -> Rectangle(parts[1].toDouble(), parts[2].toDouble())
            else -> throw IllegalArgumentException("Unknown shape: ${parts[0]}")
        }
        shapes.add(shape)
    }

    shapes.forEach { shape ->
        val area = "%.2f".format(shape.area())
        val perimeter = "%.2f".format(shape.perimeter())
        println("${shape.describe()}: area=$area, perimeter=$perimeter")
    }

    val totalArea = "%.2f".format(shapes.sumOf { it.area() })
    println("Total area: $totalArea")
}
```

## 解説

### インターフェース
関数やプロパティの契約（コントラクト）を定義：
```kotlin
interface Shape {
    fun area(): Double      // 実装を持たない（抽象メンバー）
    fun perimeter(): Double
}
```
- コンストラクタを持てない
- 複数のインターフェースを実装可能

### 抽象クラス vs インターフェース
| 特徴 | 抽象クラス | インターフェース |
|---|---|---|
| 継承 | 単一のみ | 複数可能 |
| コンストラクタ | あり | なし |
| 状態（プロパティ） | 保持可能 | バッキングフィールドなし |

### override キーワード
親クラスやインターフェースのメンバーを上書き：
```kotlin
class Circle : Shape {
    override fun area(): Double = PI * radius * radius
}
```

### ポリモーフィズム
異なる型のオブジェクトを共通のインターフェース型として扱える：
```kotlin
val shapes: List<Shape> = listOf(Circle(5.0), Rectangle(4.0, 6.0))
shapes.forEach { println(it.area()) }  // 各図形のarea()が呼ばれる
```

### 委譲（delegation）
`by` キーワードでインターフェースの実装を別のオブジェクトに委譲：
```kotlin
class CanvasSession(val tool: DrawingTool) : DrawingTool by tool
```
