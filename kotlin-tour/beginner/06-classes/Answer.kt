data class Employee(val name: String, val salary: Int)

fun main() {
    val n = readLine()!!.toInt()
    val employees = mutableListOf<Employee>()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        employees.add(Employee(parts[0], parts[1].toInt()))
    }

    employees.forEach { println(it) }
    println("Average salary: ${employees.map { it.salary }.average().toInt()}")
    println("Highest paid: ${employees.maxByOrNull { it.salary }?.name}")
}
