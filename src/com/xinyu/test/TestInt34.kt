package com.xinyu.test

class TestInt34 {
    //https://leetcode.cn/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=leetcode-75
    /**
     *
     *
    1137. 第 N 个泰波那契数
    提示
    简单
    287
    相关企业
    泰波那契序列 Tn 定义如下：

    T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

    给你整数 n，请返回第 n 个泰波那契数 Tn 的值。



    示例 1：

    输入：n = 4
    输出：4
    解释：
    T_3 = 0 + 1 + 1 = 2
    T_4 = 1 + 1 + 2 = 4
    示例 2：

    输入：n = 25
    输出：1389537


    提示：

    0 <= n <= 37
    答案保证是一个 32 位整数，即 answer <= 2^31 - 1。


    递归就行了吧？？？
    递归有一个问题 就是重复计算
    所以可以用动态规划

     */
    fun tribonacci(n: Int): Int {
        var result: Int
        when (n) {
            0 -> {
                result = 0
            }

            1, 2 -> {
                result = 1
            }
            else -> {
                var t1 = 0
                var t2 = 1
                var t3 = 1
                var i = 3
                while (i <= n) {
                    result = t1 + t2 + t3
                    t1 = t2
                    t2 = t3
                    t3 = result
                    i++
                }
                result = t3
            }
        }

        return result
    }
}