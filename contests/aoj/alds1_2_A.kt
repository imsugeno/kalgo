fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }.toMutableList()
    var hasNext = true
    while (hasNext) {
        hasNext = false
        for (i in n-1 downTo 1) {
            if (nums[i] < nums[i - 1]) {
                val temp = nums[i]
                nums[i] = nums[i - 1]
                nums[i - 1] = temp
                hasNext = true
            }
        }
    }
    println(nums)
}