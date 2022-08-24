package com.xinyu.test

class TestArray134 {
    /**
     * https://leetcode.cn/problems/determine-whether-matrix-can-be-obtained-by-rotation/
     *
     *
     * 1886. 判断矩阵经轮转后是否一致
    给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。



    示例 1：


    输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
    输出：true
    解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
    示例 2：


    输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
    输出：false
    解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
    示例 3：


    输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
    输出：true
    解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。


    提示：

    n == mat.length == target.length
    n == mat[i].length == target[i].length
    1 <= n <= 10
    mat[i][j] 和 target[i][j] 不是 0 就是 1

     */

    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val n = mat.size
        var a = n - 1
        var b360 = true
        var b90 = true
        var b180 = true
        var b270 = true
        for (i in 0 until n) {
            for (j in 0 until n) {
                //360 0
                if (mat[i][j] != target[i][j]) {
                    b360 = false
                }

                //90
                if (mat[i][j] != target[j][a - i]) {
                    b90 = false
                }

                //180
                if (mat[i][j] != target[a - i][a - j]) {
                    b180 = false
                }

                //270
                if (mat[i][j] != target[a - j][i]) {
                    b270 = false

                }
            }
        }
        return b360 || b180 || b270 || b90
    }

}