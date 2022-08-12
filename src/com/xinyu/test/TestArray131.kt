package com.xinyu.test

class TestArray131 {
    /**
     * https://leetcode.cn/problems/jump-game-ii/
     * 45. 跳跃游戏 II
    给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

    数组中的每个元素代表你在该位置可以跳跃的最大长度。

    你的目标是使用最少的跳跃次数到达数组的最后一个位置。

    假设你总是可以到达数组的最后一个位置。



    示例 1:

    输入: nums = [2,3,1,1,4]
    输出: 2
    解释: 跳到最后一个位置的最小跳跃数是 2。
    从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
    示例 2:

    输入: nums = [2,3,0,1,4]
    输出: 2


    提示:

    1 <= nums.length <= 104
    0 <= nums[i] <= 1000

     */

    fun jump(nums: IntArray): Int {
        val dp = Array(nums.size) { 0 }
        if (nums.size == 1){
            return 0
        }
        dp[0] = 1

        nums.forEachIndexed { index, i ->
            for (j in index..(index + i).coerceAtMost(nums.size -1)){
                if (dp[j] != 0){
                    dp[j] = (dp[index] + 1).coerceAtMost(dp[j])
                }else{
                    dp[j] = if(index == 0) dp[index] else dp[index] + 1
                }
            }
        }

        return dp[nums.size - 1]
    }
}

fun main() {
    println(TestArray131().jump(intArrayOf(2, 3, 1, 1, 4)))
}