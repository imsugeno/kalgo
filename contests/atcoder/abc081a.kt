//fun main() {
//    val numsStr = readln()
//    val nums = numsStr.map { it.digitToInt() }
//    var count = 0
//    for (num in nums) {
//        if (num == 1) {
//            count++
//        }
//    }
//
//    println(count)
//}

fun main() {
    val count = readln().count { it == '1' }
    println(count)
}