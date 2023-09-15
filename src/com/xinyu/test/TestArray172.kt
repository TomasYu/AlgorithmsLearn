package com.xinyu.test

class TestArray172 {
    /**
     *
     *给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

    https://leetcode.cn/problems/spiral-matrix-ii/
     */

    fun generateMatrix(n: Int): Array<IntArray> {
        val direction = listOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        val result = Array(n) { IntArray(n) { -1 } }
        var dIndex = 0
        var curRow = 0
        var curCol = 0
        var curValue = 1
        while (curValue <= n * n) {
            result[curRow][curCol] = curValue
            curValue++
            val nextRow = curRow + direction[dIndex][0]
            val nextCol = curCol + direction[dIndex][1]
            if (nextRow >= n || nextRow < 0 ||
                nextCol >= n || nextCol < 0 ||
                result [nextRow][nextCol] != -1
            ) {
                dIndex = (dIndex + 1) % 4
            }
            curRow += direction[dIndex][0]
            curCol += direction[dIndex][1]
        }
        return result
    }
}