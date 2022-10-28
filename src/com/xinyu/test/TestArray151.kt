package com.xinyu.test

import kotlin.math.abs

class TestArray151 {
    /**
     * https://leetcode.cn/problems/minimum-average-difference/
     * 2256. 最小平均差
    给你一个下标从 0 开始长度为 n 的整数数组 nums 。

    下标 i 处的 平均差 指的是 nums 中 前 i + 1 个元素平均值和 后 n - i - 1 个元素平均值的 绝对差 。两个平均值都需要 向下取整 到最近的整数。

    请你返回产生 最小平均差 的下标。如果有多个下标最小平均差相等，请你返回 最小 的一个下标。

    注意：

    两个数的 绝对差 是两者差的绝对值。
    n 个元素的平均值是 n 个元素之 和 除以（整数除法） n 。
    0 个元素的平均值视为 0 。


    示例 1：

    输入：nums = [2,5,3,9,5,3]
    输出：3
    解释：
    - 下标 0 处的平均差为：|2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3 。
    - 下标 1 处的平均差为：|(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2 。
    - 下标 2 处的平均差为：|(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2 。
    - 下标 3 处的平均差为：|(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0 。
    - 下标 4 处的平均差为：|(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1 。
    - 下标 5 处的平均差为：|(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4 。
    下标 3 处的平均差为最小平均差，所以返回 3 。
    示例 2：

    输入：nums = [0]
    输出：0
    解释：
    唯一的下标是 0 ，所以我们返回 0 。
    下标 0 处的平均差为：|0 / 1 - 0| = |0 - 0| = 0 。


    提示：

    1 <= nums.length <= 105
    0 <= nums[i] <= 105

    思路？？？
    正常思路去解决？
    左右遍历两遍  拿到坐边的和以及右边的和？ 或者直接左边的平局值  右边的平均值  避免重复运算

    右边的不能包含这个数字  左边的可以
     */

    fun minimumAverageDifference(nums: IntArray): Int {
        //0位表示左边  1表示右边
        var dp = Array(nums.size) {
            LongArray(2) { 0 }
        }
        //
        for (i in nums.indices) {
            dp[i][0] = if (i >= 1) dp[i - 1][0] + nums[i].toLong() else nums[i].toLong()
        }

        for (i in nums.size - 1 downTo 0) {
            dp[i][1] = if (i < nums.size - 1) (nums[i + 1] + dp[i + 1][1]) else 0
        }

        var cur = Int.MAX_VALUE
        var result = Int.MAX_VALUE
        for (i in nums.indices) {
            val maximumValue =
                Math.abs(dp[i][0] / (i + 1) - if (i == nums.size - 1) dp[i][1] else dp[i][1] / (nums.size - 1 - i))
            if (maximumValue < cur) {
                result = i
            }
            cur = cur.coerceAtMost(maximumValue.toInt())
        }
        return result
    }
}

fun main() {
    println(TestArray151().minimumAverageDifference(intArrayOf(2, 5, 3, 9, 5, 3)))
}