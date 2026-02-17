class Thermostat {
    val history = mutableListOf<Double>()

    var temperature: Double = 0.0
        set(value) {
            if (value < 0) {
                println("Warning: Temperature below 0°C!")
            }
            field = value
            history.add(value)
            println("Temperature set to ${"%.1f".format(value)}°C (${"%.1f".format(fahrenheit)}°F)")
        }

    val fahrenheit: Double
        get() = temperature * 9.0 / 5.0 + 32.0
}

fun main() {
    val thermostat = Thermostat()
    val n = readLine()!!.toInt()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        thermostat.temperature = parts[2].toDouble()
    }

    println("Latest: ${"%.1f".format(thermostat.temperature)}°C")
    println("History: ${thermostat.history}")
}
