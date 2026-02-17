data class User(var name: String, var email: String, var age: Int)

fun main() {
    val inputName = readLine()!!
    val inputEmail = readLine()!!
    val inputAge = readLine()!!.toInt()

    val user = User(inputName, inputEmail, inputAge).also {
        println("Creating user: ${it.name}")
    }

    with(user) {
        println("User(name=$name, email=$email, age=$age)")
    }

    val nameLength = user.name.let { it.length }
    println("Name length: $nameLength")

    user.apply {
        email = "${name.lowercase()}_updated@example.com"
    }
    println("Updated email: ${user.email}")
}
