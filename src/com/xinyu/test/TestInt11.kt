package com.xinyu.test

class TestInt11 {
    /**
     * https://leetcode.cn/problems/counting-bits/
     *
     *
     * 338. 比特位计数
    给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。



    示例 1：

    输入：n = 2
    输出：[0,1,1]
    解释：
    0 --> 0
    1 --> 1
    2 --> 10
    示例 2：

    输入：n = 5
    输出：[0,1,1,2,1,2]
    解释：
    0 --> 0
    1 --> 1
    2 --> 10
    3 --> 11
    4 --> 100
    5 --> 101


    提示：

    0 <= n <= 105


    进阶：

    很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
    你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
    😄

     这个题是很有意思的
     */

    fun countBits(n: Int): IntArray {
        val intArray = IntArray(n + 1)

        var highBit = 0
        for (i in 1..n) {
            if ((i and (i - 1)) == 0) {
                intArray[i] = 1
                highBit = i
            } else {
                intArray[i] = intArray[i - highBit] + 1
            }
        }
        return intArray
    }
}


fun main() {
    println(TestInt11().countBits(200).contentToString())
}
