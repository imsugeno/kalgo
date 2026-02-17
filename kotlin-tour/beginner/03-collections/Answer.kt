fun main() {
    val n = readLine()!!.toInt()
    val fruits = readLine()!!.split(" ")
    val searchFruit = readLine()!!

    println("List: $fruits")
    println("Count: ${fruits.count()}")
    println("First: ${fruits.first()}")
    println("Last: ${fruits.last()}")

    val uniqueFruits = fruits.toSet()
    println("Unique: ${uniqueFruits.toList()}")
    println("Unique count: ${uniqueFruits.count()}")
    println("$searchFruit found: ${searchFruit in fruits}")
}
