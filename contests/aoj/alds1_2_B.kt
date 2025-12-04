fun main() {
    readln()
    val nums = readln().split(" ").map { it.toInt() }.toMutableList()

    selectionSort(nums)
    println(nums)
}

fun selectionSort(nums: MutableList<Int>) {
    for (i in 0..<nums.size) {
        var minj = i
        for (j in i..<nums.size) {
            if (nums[j] < nums[minj]) {
                minj = j
            }
        }
        nums[minj] = nums[i].also { nums[i] = nums[minj] }
    }
}