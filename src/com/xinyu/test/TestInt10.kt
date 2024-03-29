package com.xinyu.test

class TestInt10 {
    /**
     * 70. 爬楼梯
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？



    示例 1：

    输入：n = 2
    输出：2
    解释：有两种方法可以爬到楼顶。
    1. 1 阶 + 1 阶
    2. 2 阶
    示例 2：

    输入：n = 3
    输出：3
    解释：有三种方法可以爬到楼顶。
    1. 1 阶 + 1 阶 + 1 阶
    2. 1 阶 + 2 阶
    3. 2 阶 + 1 阶


    提示：

    1 <= n <= 45



    本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和

    爬上 n-1n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
    爬上 n-2n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
    所以我们得到公式 dp[n] = dp[n-1] + dp[n-2]dp[n]=dp[n−1]+dp[n−2]
    同时需要初始化 dp[0]=1dp[0]=1 和 dp[1]=1dp[1]=1
    时间复杂度：O(n)O(n)

    作者：guanpengchn
    链接：https://leetcode.cn/problems/climbing-stairs/solution/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    fun climbStairs(n: Int): Int {

        val intArray = IntArray(n + 1)
        intArray[0] = 1
        intArray[1] = 1
        for (i in 2..n) {
            intArray[i] = intArray[i - 1] + intArray[i - 2]
        }
        return intArray[n]
    }


    /**
     * 滚动数组
     */
    fun climbStairs2(n: Int): Int {
        var q = 1
        var p = 1
        var result = 1
        for (i in 2..n) {
            result = q + p
            q = p
            p = result
        }
        return result
    }
}