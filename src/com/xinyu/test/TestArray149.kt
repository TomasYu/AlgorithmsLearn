package com.xinyu.test

import kotlin.math.sign

class TestArray149 {
    /**
     * https://leetcode.cn/problems/max-black-square-lcci/
     *
     * 面试题 17.23. 最大黑方阵
    给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。

    返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。

    示例 1:

    输入:
    [
    [1,0,1],
    [0,0,1],
    [0,0,1]
    ]
    输出: [1,0,2]
    解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
    示例 2:

    输入:
    [
    [0,1,1],
    [1,0,1],
    [1,1,0]
    ]
    输出: [0,0,1]
    提示：

    matrix.length == matrix[0].length <= 200
     */

    fun findSquare(matrix: Array<IntArray>): IntArray {
        var result = IntArray(3) { 0 }
        var row = matrix.size
        var col = matrix[0].size
        var toRight = Array(row) {
            IntArray(col) { 0 }
        }
        var toBottom = Array(row) {
            IntArray(col) { 0 }
        }

        for (i in row - 1 downTo 0) {
            for (j in col - 1 downTo 0) {
                if (matrix[i][j] == 0) {
                    if (j == col - 1) {
                        toRight[i][j] = 1
                    } else {
                        toRight[i][j] = toRight[i][j + 1] + 1
                    }
                    if (i == row - 1) {
                        toBottom[i][j] = 1
                    } else {
                        toBottom[i][j] = toBottom[i + 1][j] + 1
                    }
                }
            }
        }

        for (i in 0 until row){
            for (j in 0 until col){
                val side = toRight[i][j].coerceAtMost(toBottom[i][j])
                if (side > result[2]){
                    for (k in 0 until side){
                        if (toRight[i + k][j] >= side && toBottom[i][j + k] >= side){
                            result[0] = i
                            result[1] = j
                            result[2] = side
                        }
                    }
                }

            }
        }
        if (result[2] == 0){
            return intArrayOf()
        }
        return result
    }
}

fun main() {
    /**
     *   [
    [0,1,1],
    [1,0,1],
    [1,1,0]
    ]
     */
    println(TestArray149().findSquare(arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 0))).contentToString())
}