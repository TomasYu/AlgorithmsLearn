package com.xinyu.test

import kotlin.math.cos

class TestArray125 {
    /**
     * https://leetcode.cn/problems/min-cost-climbing-stairs/
     * 746. 使用最小花费爬楼梯
    给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。

    你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。

    请你计算并返回达到楼梯顶部的最低花费。



    示例 1：

    输入：cost = [10,15,20]
    输出：15
    解释：你将从下标为 1 的台阶开始。
    - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
    总花费为 15 。
    示例 2：

    输入：cost = [1,100,1,1,1,100,1,1,100,1]
    输出：6
    解释：你将从下标为 0 的台阶开始。
    - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
    - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
    - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
    - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
    - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
    - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
    总花费为 6 。


    提示：

    2 <= cost.length <= 1000
    0 <= cost[i] <= 999

     */

    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size + 1) { 0 }
        dp.forEachIndexed { index, i ->
            if (index < 2) {
                dp[index] = 0
            } else {
                dp[index] = (cost[index - 1] + dp[index - 1]).coerceAtMost(cost[index - 2] + dp[index - 2])
            }

        }
        return dp[cost.size]
    }


    fun minCostClimbingStairs2(cost: IntArray): Int {
        var pre = 0
        var pre_pre = 0
        val n = cost.size
        for (i in 2..n) {
            val new = (pre + cost[i - 1]).coerceAtMost(pre_pre + cost[i - 2])
            pre_pre = pre
            pre = new
        }
        return pre
    }
}

fun main() {
    println(TestArray125().minCostClimbingStairs(intArrayOf(10, 15, 20)))
}
