package com.xinyu.test

class TestArray129 {
    /**
     * 474. 一和零
    给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

    请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。

    如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。



    示例 1：

    输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
    输出：4
    解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
    其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
    示例 2：

    输入：strs = ["10", "0", "1"], m = 1, n = 1
    输出：2
    解释：最大的子集是 {"0", "1"} ，所以答案是 2 。


    提示：

    1 <= strs.length <= 600
    1 <= strs[i].length <= 100
    strs[i] 仅由 '0' 和 '1' 组成
    1 <= m, n <= 100

    https://leetcode.cn/problems/ones-and-zeroes/
     */
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {

        val size = strs.size
        val dp = Array(size + 1) { Array(m + 1) { Array(n + 1) { 0 } } }

        //统计0 和 1 的个数
//        val array = Array(size) { Array(2) { 0 } }
        val function: (Int) -> Array<Int> = {
            Array(2) { 0 }
        }
        val array = Array(size, function)
        strs.forEachIndexed { index, s ->
            val toCharArray = s.toCharArray()
            toCharArray.forEach {
                if (it == '0') {
                    array[index][0]++
                } else {
                    array[index][1]++
                }
            }
        }


        //填充dp数组
        for (i in 0..size) {
            for (j in 0..m) {
                for (k in 0..n) {
                    if (i > 0) {
                        dp[i][j][k] = dp[i - 1][j][k]
                        if (j - array[i - 1][0] >= 0 && k - array[i - 1][1] >= 0) {
                            dp[i][j][k] =
                                dp[i][j][k].coerceAtLeast(dp[i - 1][j - array[i - 1][0]][k - array[i - 1][1]] + 1)
                        }
                    }
                }
            }
        }
        return dp[size][m][n]
    }

}

fun main() {
//    println(Integer.parseInt("2203366414"))
    println(TestArray129().findMaxForm(arrayOf("10", "0001", "111001", "1", "0"), 5, 3))
}