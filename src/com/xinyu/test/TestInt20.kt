package com.xinyu.test

class TestInt20 {
    /**
     * 剑指 Offer 10- I. 斐波那契数列
    写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。



    示例 1：

    输入：n = 2
    输出：1
    示例 2：

    输入：n = 5
    输出：5


    提示：

    0 <= n <= 100
    https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
     */
    fun fib(n: Int): Int {
        if (n < 2) {
            return n
        }
        var pre_pre = 0
        var pre = 1
        var result = 0

        for (i in 2..n) {
            result = (pre + pre_pre) % 1000000007
            pre_pre = pre
            pre = result
            println("$pre_pre")
        }
        return result
    }
}

fun main() {
    println(TestInt20().fib(100))
}