package com.xinyu.test

import kotlin.math.min

class TestArray150 {
    /**
     * https://leetcode.cn/problems/largest-plus-sign/
     *
     * 764. 最大加号标志
    在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0

    返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。

    一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。



    示例 1：



    输入: n = 5, mines = [[4, 2]]
    输出: 2
    解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
    示例 2：



    输入: n = 1, mines = [[0, 0]]
    输出: 0
    解释: 没有加号标志，返回 0 。


    提示：

    1 <= n <= 500
    1 <= mines.length <= 5000
    0 <= xi, yi < n
    每一对 (xi, yi) 都 不重复


    思路？？？？
    记录每一个坐标的上下左右边长
    遍历4次  上下左右
    遍历数组  每一个位置以最短的边长存放结果
    最后拿到结果

    思路是对的  也能写出来  可能有一点优化空间就是可以2次遍历就行
     */

    fun orderOfLargestPlusSign(n: Int, mines: Array<IntArray>): Int {
        //左上右下
        var dp = Array(n) { Array(n) { Array(4) { 0 } } }

        var matrix = Array(n) { Array(n) { 1 } }
        for (mine in mines) {
            matrix[mine[0]][mine[1]] = 0
        }

        //左上
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 1) {
                    dp[i][j][0] = if (j - 1 >= 0) dp[i][j - 1][0] + 1 else 1
                    dp[i][j][1] = if (i - 1 >= 0) dp[i - 1][j][1] + 1 else 1
                }
            }
        }

        //右下
        for (i in n - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                if (matrix[i][j] == 1) {
                    dp[i][j][2] = if (j + 1 < n) dp[i][j + 1][2] + 1 else 1
                    dp[i][j][3] = if (i + 1 < n) dp[i + 1][j][3] + 1 else 1
                }
            }
        }

        var result = 0
        dp.forEachIndexed { i, arrays ->
            arrays.forEachIndexed { j, _ ->
                result = result.coerceAtLeast(
                    (dp[i][j][0]).coerceAtMost(dp[i][j][1]).coerceAtMost(dp[i][j][2])
                        .coerceAtMost(dp[i][j][3])
                )
            }
        }

        return result
    }
}

fun main() {
    println(TestArray150().orderOfLargestPlusSign(5, arrayOf(intArrayOf(4, 2))))
}