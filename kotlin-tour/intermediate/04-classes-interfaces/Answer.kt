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
