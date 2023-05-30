package com.xinyu.test

import java.util.*
import java.util.function.Function
import kotlin.streams.toList


class TestArray168 {
    //https://leetcode.cn/problems/coloring-a-border/
    /**
     * https://leetcode.cn/problems/coloring-a-border/
     *1034. 边界着色
    给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。

    两个网格块属于同一 连通分量 需满足下述全部条件：

    两个网格块颜色相同
    在上、下、左、右任意一个方向上相邻
    连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：

    在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻
    在网格的边界上（第一行/列或最后一行/列）
    请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。



    示例 1：

    输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
    输出：[[3,3],[3,2]]
    示例 2：

    输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
    输出：[[1,3,3],[2,3,3]]
    示例 3：

    输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
    输出：[[2,2,2],[2,1,2],[2,2,2]]


    提示：

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    1 <= grid[i][j], color <= 1000
    0 <= row < m
    0 <= col < n
     */

    //一定要注意是边界
    fun colorBorder(grid: Array<IntArray>, row: Int, col: Int, color: Int): Array<IntArray> {
        //简单粗暴 直接按照思路走
        //题意有点难懂 边界 边界 那怎么办呢？？？
        val dp = Array(grid.size) {
            BooleanArray(grid[0].size) { false }
        }
        //注意这里需要对二维数组 进行深copy
        val copyOf = grid.map { t -> t.copyOf() }.toTypedArray()

        dfs(grid, grid[row][col], color, row, col, dp,copyOf)

        return grid
    }

    fun dfs(grid: Array<IntArray>, old: Int, new: Int, row: Int, col: Int, dp: Array<BooleanArray>, origin: Array<IntArray>) {
        if (row in grid.indices && col in grid[0].indices && origin[row][col] == old && !dp[row][col]) {
            dp[row][col] = true
            if (row == 0 || row == grid.size - 1 || col == 0 || col == grid[0].size - 1 || board(origin,row,col)) {
                grid[row][col] = new
            }
            dfs(grid, old, new, row + 1, col, dp,origin)
            dfs(grid, old, new, row, col + 1, dp,origin)
            dfs(grid, old, new, row - 1, col, dp,origin)
            dfs(grid, old, new, row, col - 1, dp,origin)
        }
    }
    fun board(grid: Array<IntArray>, row: Int, col: Int) : Boolean{
        if (row in grid.indices && col in grid[0].indices){
            if (
                grid[row + 1][col] != grid[row][col] ||
                grid[row - 1][col] != grid[row][col] ||
                grid[row ][col + 1] != grid[row][col] ||
                grid[row ][col - 1] != grid[row][col]

            ){
                return true
            }
        }
        return false
    }

}