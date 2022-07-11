package com.xinyu.test

class TestInt14 {
    /**
     * 面试题 08.01. 三步问题
    三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

    示例1:

    输入：n = 3
    输出：4
    说明: 有四种走法
    示例2:

    输入：n = 5
    输出：13
    提示:

    n范围在[1, 1000000]之间


    f(n)表示，上到第n+1个台阶有多少种方法
    一次可以上1阶、2阶、3阶，所有f(n)仅与f(n-3)、f(n-2)、f(n-1)有关
    f(n) = f(n-3) + f(n-2) + f(n-1)

    作者：huyii
    链接：https://leetcode.cn/problems/three-steps-problem-lcci/solution/mian-shi-ti-0801-san-bu-wen-ti-by-huyii-s5u6/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    fun waysToStep(n: Int): Int {
        when (n) {
            1 -> {
                return 1
            }
            2 -> {
                return 2
            }
            3 -> {
                return 4
            }
        }
        if (n <= 1) return 1
        val dp = Array(n + 1) { 0 }
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        for (i in 4..n) {
            dp[i] += ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007
        }
        return dp[n]
    }
}

fun main() {
    println(TestInt14().waysToStep(61))
}