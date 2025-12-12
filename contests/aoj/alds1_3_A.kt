class Stack(val max: Int) {
    private val stack = MutableList(max) { 0 }
    var top = 0

    fun push(x: Int): Result<Unit> {
        if (this.isMax()) {
            return Result.failure(IllegalStateException("stack overflow"))
        }

        top++
        stack[top] = x
        return Result.success(Unit)
    }

    fun pop(): Result<Int> {
        if (this.isEmpty()) {
            return Result.failure(IllegalStateException("stack overflow"))
        }

        top--
        return Result.success(stack[top+1])
    }

    fun initialize() {
        top = 0
    }

    fun isEmpty(): Boolean {
        return top == 0
    }

    fun isMax(): Boolean {
        return top >= max - 1
    }
}

fun main() {
    val input = readln().split(" ")
    val stack = Stack(input.size * 10)

    for (x in input) {
        if (x == "+" || x == "-" || x == "*") {
            val a = stack.pop().getOrThrow()
            val b = stack.pop().getOrThrow()
            when (x) {
                "+" -> stack.push(a + b)
                "-" -> stack.push(b - a)
                "*" -> stack.push(a * b)
            }
            continue
        }

        stack.push(x.toInt())
    }

    println(stack.pop())
}