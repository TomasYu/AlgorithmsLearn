package com.xinyu.test

class TestArray170 {
    /**
    https://leetcode.cn/problems/gray-code/
    89. 格雷编码
    中等
    642
    相关企业
    n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
    每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
    第一个整数是 0
    一个整数在序列中出现 不超过一次
    每对 相邻 整数的二进制表示 恰好一位不同 ，且
    第一个 和 最后一个 整数的二进制表示 恰好一位不同
    给你一个整数 n ，返回任一有效的 n 位格雷码序列 。



    示例 1：

    输入：n = 2
    输出：[0,1,3,2]
    解释：
    [0,1,3,2] 的二进制表示是 [00,01,11,10] 。
    - 00 和 01 有一位不同
    - 01 和 11 有一位不同
    - 11 和 10 有一位不同
    - 10 和 00 有一位不同
    [0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
    - 00 和 10 有一位不同
    - 10 和 11 有一位不同
    - 11 和 01 有一位不同
    - 01 和 00 有一位不同
    示例 2：

    输入：n = 1
    输出：[0,1]


    提示：

    1 <= n <= 16



    怎么样把一个数的最高位从0变成1呢
    在原来的基础上增加2的n次就可以
    但是怎么求出来一个数2进制有几位呢


    二进制操作还是有些问题啊
    怎么知道二进制的最高位？？？
     */

    fun grayCode(n: Int): List<Int> {
        val result = mutableListOf<Int>()
        dfs(n , result)
        return result
    }

    fun dfs(n: Int, list: MutableList<Int>): Int {
        if (n == 0) {
            list.add(0)
            return 0
        }
        val shift = dfs(n - 1, list)
        for (j in list.size - 1 downTo 0) {
            list.add(list[j] + (1 shl shift))
        }
        return shift + 1
    }
}

fun main() {
    println(TestArray170().grayCode(2))
}
