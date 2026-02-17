enum class Color { RED, GREEN, BLUE }

sealed class Command {
    data class Move(val x: Int, val y: Int) : Command()
    data class Draw(val shape: String, val color: Color) : Command()
    data object Stop : Command()
}

fun parseCommand(line: String): Command {
    val parts = line.split(" ")
    return when (parts[0]) {
        "MOVE" -> Command.Move(parts[1].toInt(), parts[2].toInt())
        "DRAW" -> Command.Draw(parts[1], Color.valueOf(parts[2]))
        "STOP" -> Command.Stop
        else -> throw IllegalArgumentException("Unknown command: ${parts[0]}")
    }
}

fun executeCommand(command: Command): String = when (command) {
    is Command.Move -> "Moving to (${command.x}, ${command.y})"
    is Command.Draw -> "Drawing ${command.color} ${command.shape}"
    is Command.Stop -> "Stopped"
}

fun main() {
    val n = readLine()!!.toInt()
    val commands = List(n) { parseCommand(readLine()!!) }

    commands.forEach { println(executeCommand(it)) }

    println("Commands executed: ${commands.size}")
    println("Move commands: ${commands.count { it is Command.Move }}")
    println("Draw commands: ${commands.count { it is Command.Draw }}")
}
