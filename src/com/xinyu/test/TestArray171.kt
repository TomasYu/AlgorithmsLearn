package com.xinyu.test

import java.util.ArrayList

class TestArray171 {
    //https://leetcode.cn/problems/spiral-matrix/
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。



    示例 1：


    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    输出：[1,2,3,6,9,8,7,4,5]
    示例 2：


    输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    输出：[1,2,3,4,8,12,11,10,9,5,6,7]


    提示：

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100


    想法？？？？
    如果按照题意直接写 有点复杂
    一会上下左右的


    其实一次就是一个圈
    也还可以接受？？？
    每次把圈的范围缩小
    然后进行递归调用


    能看懂就不错了
    写不出来的
    费很大劲才能看懂
    别说让他做出来了

    但是看了别人的就很简单


    谁有功夫鼓励谁啊？只能自己鼓励自己，
    自己夸奖自己，让自己往前发展。
    自己安慰自己


    终于做出来了
    看题解做出来的
    是不是没有体会到数学的乐趣？？
    逻辑的乐趣？？？？
     */
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val row = matrix.size
        val col = matrix[0].size
        val list = mutableListOf<Int>()
        val direction = listOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        val visited = Array(row) { BooleanArray(col) { false } }
        var dIndex = 0
        var curRow = 0
        var curCol = 0
        while (list.size < row * col) {
            list.add(matrix[curRow][curCol])
            visited[curRow][curCol] = true

            val nextRow = curRow + direction[dIndex][0]
            val nextCol = curCol + direction[dIndex][1]
            if (nextRow >= row || nextRow < 0 ||
                nextCol >= col || nextCol < 0 ||
                visited [nextRow][nextCol]
            ) {
                dIndex = (dIndex + 1) % 4
            }
            curRow += direction[dIndex][0]
            curCol += direction[dIndex][1]
        }
        return list
    }

    fun dfs(row: Int, col: Int, matrix: Array<IntArray>, cur: Int, list: MutableList<Int>) {
        // 0 ？？ 1 ？？
        //这种写法想的我都头疼
        //能不能直接一次遍历两行？
        //边界的判断太繁琐

        // 一共有几圈呢？？？ 重复的问题怎么处理？？？
        //还要记SP？？？
        for (i in 0..col) {

        }
        dfs(row, col, matrix, cur + 1, list)
    }

}

fun main() {
    println(9 < 9)
    //null 可以是任何类型
    ArrayList<Int>(null)
}