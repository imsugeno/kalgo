fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }.toMutableList()

    for (i in 1..<n) {
        val target = nums[i]
        var j = i - 1
        while (j >= 0 && nums[j] > target) {
            nums[j+1] = nums[j]
            println("i=$i 途中経過: $nums")
            j--
        }
        nums[j+1] = target
        println("i=$i 最終結果: $nums")
    }
}