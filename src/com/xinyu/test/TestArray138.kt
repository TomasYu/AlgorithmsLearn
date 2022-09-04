package com.xinyu.test

class TestArray138 {
    /**
     *
     * 304. 二维区域和检索 - 矩阵不可变
    给定一个二维矩阵 matrix，以下类型的多个请求：

    计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
    实现 NumMatrix 类：

    NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
    int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。


    示例 1：



    输入:
    ["NumMatrix","sumRegion","sumRegion","sumRegion"]
    [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
    输出:
    [null, 8, 11, 12]

    解释:
    NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
    numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
    numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
    numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)


    提示：

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 200
    -105 <= matrix[i][j] <= 105
    0 <= row1 <= row2 < m
    0 <= col1 <= col2 < n
    最多调用 104 次 sumRegion 方法

     * https://leetcode.cn/problems/range-sum-query-2d-immutable/
     */


}

//fun main() {
//    val intArray = IntArray(3) {
//        it + 1
//    }
//    intArray[2]
//}

class NumMatrix(matrix: Array<IntArray>) {
    var matrix = matrix

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var result = 0
        for (i in row1..row2) {
            for (j in col1..col2) {
                result += matrix[i][j]
            }
        }
        matrix
        return result
    }

}

class NumMatrix2(matrix: Array<IntArray>) {
    var sum = Array<IntArray>(matrix.size) { IntArray(matrix[0].size) { 0 } }

    init {
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                var temp = 0
                var needShort = 0
                if (i - 1 >= 0) {
                    temp += sum[i - 1][j]
                    needShort ++
                }
                if (j - 1 >= 0) {
                    temp += sum[i][j - 1]
                    needShort ++

                }
                temp += matrix[i][j]
                if (needShort == 2){
                    temp -= sum[i-1][j-1]
                }
                sum[i][j] = temp
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var result = sum[row2][col2]
        if (row1 -1 >=0){
            result-=sum[row1-1][col2]
        }
        if (col1 -1 >=0){
            result-=sum[row2][col1-1]

        }
        if (row1 -1 >=0 && col1 -1 >=0){
            result+= sum[row1 -1][col1-1]
        }
        return result
    }

}



class NumMatrix3(matrix: Array<IntArray>) {
    var sum = Array<IntArray>(matrix.size + 1) { IntArray(matrix[0].size + 1) { 0 } }

    init {
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1]
    }

}
fun main() {
    println(
        NumMatrix2(
            arrayOf(
                intArrayOf(3, 0, 1, 4, 2),
                intArrayOf(5, 6, 3, 2, 1),
                intArrayOf(1, 2, 0, 1, 5),
                intArrayOf(4, 1, 0, 1, 7),
                intArrayOf(1, 0, 3, 0, 5)
            )
        ).sumRegion(
            2, 1, 4, 3
        )
    )
}
