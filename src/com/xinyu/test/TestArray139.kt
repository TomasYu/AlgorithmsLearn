package com.xinyu.test

class TestArray139 {
    /**
     * 1594. 矩阵的最大非负积
    给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。

    在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。

    返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。

    注意，取余是在得到最大积之后执行的。



    示例 1：

    输入：grid = [[-1,-2,-3],
    [-2,-3,-3],
    [-3,-3,-2]]
    输出：-1
    解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
    示例 2：

    输入：grid = [[1,-2,1],
    [1,-2,1],
    [3,-4,1]]
    输出：8
    解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)
    示例 3：

    输入：grid = [[1, 3],
    [0,-4]]
    输出：0
    解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)
    示例 4：

    输入：grid = [[ 1, 4,4,0],
    [-2, 0,0,1],
    [ 1,-1,1,1]]
    输出：2
    解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)


    提示：

    1 <= rows, cols <= 15
    -4 <= grid[i][j] <= 4

     */

    //通过这种方式没有做出来
//    fun maxProductPath(grid: Array<IntArray>): Int {
//        return helper(0, 0, 1, grid)
//    }
//
//    fun helper(x: Int, y: Int, curResult: Int, grid: Array<IntArray>): Int {
//        if (x == grid.size - 1 && y == grid[0].size - 1) {
//            return if (curResult * grid[x][y] >= 0) {
//                curResult * grid[x][y]
//            } else {
//                -1
//            }
//        }
//        var cur = curResult * grid[x][y]
//        //x
//        var right = 1
//        var bottom = 1
//        if (x < grid.size - 1) {
//            right = cur * helper(x + 1, y, cur, grid)
//        }
//
//        if (y < grid[0].size - 1) {
//            bottom = cur * helper(x, y + 1, cur, grid)
//        }
//        return (cur * right).coerceAtLeast(cur * bottom)
//    }

    //pair first 为最大  second 为最小
    fun maxProductPath(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) {
            Array(n) {
                LongArray(2) { 0 }
            }
        }
        dp[0][0][0] = grid[0][0].toLong()
        dp[0][0][1] = grid[0][0].toLong()
        for (i in 0 until m) {
            for (j in 0 until n) {
                val k = grid[i][j]
                var hasLeft = false
                if (i - 1 >= 0) {
                    if (k >= 0) {
                        dp[i][j][0] = dp[i - 1][j][0] * k
                        dp[i][j][1] = dp[i - 1][j][1] * k
                    } else {
                        dp[i][j][0] = dp[i - 1][j][1] * k
                        dp[i][j][1] = dp[i - 1][j][0] * k
                    }
                    hasLeft = true
                }
                if (j - 1 >= 0) {
                    if (k >= 0) {
                        dp[i][j][0] =
                            if (hasLeft) dp[i][j][0].coerceAtLeast(dp[i][j - 1][0] * k) else dp[i][j - 1][0] * k
                        dp[i][j][1] =
                            if (hasLeft) dp[i][j][1].coerceAtMost(dp[i][j - 1][1] * k) else dp[i][j - 1][1] * k
                    } else {
                        dp[i][j][0] =
                            if (hasLeft) dp[i][j][0].coerceAtLeast(dp[i][j - 1][1] * k) else dp[i][j - 1][1] * k
                        dp[i][j][1] =
                            if (hasLeft) dp[i][j][1].coerceAtMost(dp[i][j - 1][0] * k) else dp[i][j - 1][0] * k
                    }
                }
            }
        }
        return if (dp[m - 1][n - 1][0] >= 0) {
            (dp[m - 1][n - 1][0] % (1_000_000_000 + 7)).toInt()
        } else -1
    }

    fun maxProductPath2(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) {
            Array(n) {
                LongArray(2) { 0 }
            }
        }
        dp[0][0][0] = grid[0][0].toLong()
        dp[0][0][1] = grid[0][0].toLong()

        for (i in 1 until grid[0].size) {
            if (grid[0][i] > 0) {
                dp[0][i][0] = dp[0][i - 1][0] * grid[0][i]
                dp[0][i][1] = dp[0][i - 1][1] * grid[0][i]
            } else {
                dp[0][i][0] = dp[0][i - 1][1] * grid[0][i]
                dp[0][i][1] = dp[0][i - 1][0] * grid[0][i]
            }
        }

        for (i in 1 until grid.size) {
            if (grid[i][0] > 0) {
                dp[i][0][0] = dp[i - 1][0][0] * grid[i][0]
                dp[i][0][1] = dp[i - 1][0][1] * grid[i][0]
            } else {
                dp[i][0][0] = dp[i - 1][0][1] * grid[i][0]
                dp[i][0][1] = dp[i - 1][0][0] * grid[i][0]
            }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                val k = grid[i][j]
                if (k > 0) {
                    dp[i][j][0] = dp[i - 1][j][0].coerceAtLeast(dp[i][j - 1][0]) * k
                    dp[i][j][1] = dp[i - 1][j][1].coerceAtMost(dp[i][j - 1][1]) * k
                } else {
                    dp[i][j][0] = dp[i - 1][j][1].coerceAtMost(dp[i][j - 1][1]) * k
                    dp[i][j][1] = dp[i - 1][j][0].coerceAtLeast(dp[i][j - 1][0]) * k
                }
            }
        }
        return if (dp[m - 1][n - 1][0] >= 0) {
            (dp[m - 1][n - 1][0] % (1_000_000_000 + 7)).toInt()
        } else -1
    }


    fun maxProductPath3(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) {
            Array(n) {
                LongArray(2) { 0 }
            }
        }
        dp[0][0][0] = grid[0][0].toLong().also { dp[0][0][1] = it }

        for (i in 1 until grid[0].size) {
            dp[0][i][0] = (dp[0][i - 1][0] * grid[0][i]).also { dp[0][i][1] = it }
        }

        for (i in 1 until grid.size) {
            dp[i][0][0] = (dp[i - 1][0][0] * grid[i][0]).also { dp[i][0][1] = it }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                val k = grid[i][j]
                if (k > 0) {
                    dp[i][j][0] = dp[i - 1][j][0].coerceAtLeast(dp[i][j - 1][0]) * k
                    dp[i][j][1] = dp[i - 1][j][1].coerceAtMost(dp[i][j - 1][1]) * k
                } else {
                    dp[i][j][0] = dp[i - 1][j][1].coerceAtMost(dp[i][j - 1][1]) * k
                    dp[i][j][1] = dp[i - 1][j][0].coerceAtLeast(dp[i][j - 1][0]) * k
                }
            }
        }
        return if (dp[m - 1][n - 1][0] >= 0) {
            (dp[m - 1][n - 1][0] % (1_000_000_000 + 7)).toInt()
        } else -1
    }
}

fun main() {
    println(
        TestArray139().maxProductPath2(
//            arrayOf(
//                intArrayOf(-1, -2, -3),
//                intArrayOf(-2, -3, -3),
//                intArrayOf(-3, -3, -2)
//            )
            arrayOf(
                intArrayOf(1, -2, 1),
                intArrayOf(1, -2, 1),
                intArrayOf(3, -4, 1)
            )
        )
    )
}