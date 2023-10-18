package com.xinyu.test

import kotlin.math.pow

class TestString30 {
    //https://leetcode.cn/problems/number-of-ways-to-split-a-string/description/
    /**

    1573. 分割字符串的方案数
    提示
    中等
    16
    相关企业
    给你一个二进制串 s  （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个 非空 字符串 s1, s2, s3 （s1 + s2 + s3 = s）。

    请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。

    由于答案可能很大，请将它对 10^9 + 7 取余后返回。



    示例 1：

    输入：s = "1 0 1 0 1"
    输出：4
    解释：总共有 4 种方法将 s 分割成含有 '1' 数目相同的三个子字符串。
    "1|010|1"
    "1|01|01"
    "10|10|1"
    "10|1|01"
    示例 2：

    输入：s = "1001"
    输出：0
    示例 3：

    输入：s = "0 0 0 0"
    输出：3
    解释：总共有 3 种分割 s 的方法。
    "0|0|00"
    "0|00|0"
    "00|0|0"
    示例 4：

    输入：s = "1001 000 101 00 110"
    输出：12


    提示：

    s[i] == '0' 或者 s[i] == '1'
    3 <= s.length <= 10^5
     */

    /**
    这什么玩意 我擦
    这个得回溯 去做吧
    但是结果量  计算量是个考验
    dfs????
    应该不行  固定了3组

    首先 整个1的个数
    然后分完成三个
    每个的数量
    然后计算两个1之间的0的数量
    绝对有公式

    全0的单独计算
    3！ 阶乘 几个0 的阶乘
    好像不对



    高中数学没学好啊
    这本应该在15-17岁就懂得年纪
    30了还没有懂



    如果没有 就没有 哎

     */
    fun numWays(s: String): Int {
        val chars = s.toCharArray()
        val map = mutableMapOf<Int, Int>()
        var count = 0
        val base = 10.0.pow(9.0) + 7
        chars.forEachIndexed { index, c ->
            if (c == '1') {
                map[count] = index
                count++
            }
        }

        if (count == 0) {
            val size = chars.size.toLong()
            var split = size - 1
            return if (size < 3) {
                0
            } else {
                ((split * (split - 1) / 2) % base).toInt()
            }
        } else if (count % 3 == 0) {
            val split = count / 3
            //long 也能越界？？？？
            return (((map[split]!! - map[split - 1]!!).toLong() * (map[split * 2]!! - map[split * 2 - 1]!!) % base).toInt())
        } else {
            return 0
        }
    }


}

fun main() {
//    println(TestString30().numWays("100100010100110"))
    println(TestString30().numWays("010010000000001000"))
}