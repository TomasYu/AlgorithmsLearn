package com.xinyu.test

class TestArray126 {

    /**
     * 面试题 16.17. 连续数列
    给定一个整数数组，找出总和最大的连续数列，并返回总和。

    示例：

    输入： [-2,1,-3,4,-1,2,1,-5,4]
    输出： 6
    解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
    进阶：

    如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    fun maxSubArray(nums: IntArray): Int {
        val dp = Array(nums.size) { 0 }
        var max = if (nums.isNotEmpty()) nums[0] else 0
        nums.forEachIndexed { index, i ->
            if (index >= 1) {
                dp[index] = i.coerceAtLeast(dp[index - 1] + i)
            } else {
                dp[index] = i
            }
            max = max.coerceAtLeast(dp[index])
        }
        return max
    }
}

fun main() {
    println(TestArray126().maxSubArray(intArrayOf(-1,-2)))
}