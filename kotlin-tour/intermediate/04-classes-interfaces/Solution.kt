import kotlin.math.PI

// Shape インターフェースを定義（area, perimeter, describe）
// TODO: ここにコードを書いてください

// Circle クラス（Shape を実装）
// TODO: ここにコードを書いてください

// Rectangle クラス（Shape を実装）
// TODO: ここにコードを書いてください

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

    // 各図形の情報を出力
    // "[describe()]: area=[面積], perimeter=[周囲長]" (小数点2桁)
    // TODO: ここにコードを書いてください

    // 全図形の面積の合計を出力（小数点2桁）
    // TODO: ここにコードを書いてください
}
