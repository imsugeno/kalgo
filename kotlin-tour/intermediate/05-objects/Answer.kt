object ConversionCounter {
    var count = 0
    fun increment() { count++ }
}

data class Temperature(val celsius: Double) {
    val fahrenheit: Double get() = celsius * 9.0 / 5.0 + 32.0

    companion object {
        fun fromFahrenheit(f: Double): Temperature =
            Temperature((f - 32.0) * 5.0 / 9.0)
    }
}

fun main() {
    val n = readLine()!!.toInt()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        val unit = parts[0]
        val value = parts[1].toDouble()

        when (unit) {
            "celsius" -> {
                val temp = Temperature(value)
                ConversionCounter.increment()
                println("${"%.1f".format(value)}°C = ${"%.1f".format(temp.fahrenheit)}°F")
            }
            "fahrenheit" -> {
                val temp = Temperature.fromFahrenheit(value)
                ConversionCounter.increment()
                println("${"%.1f".format(value)}°F = ${"%.1f".format(temp.celsius)}°C")
            }
        }
    }

    println("Conversions performed: ${ConversionCounter.count}")
}
