package com.xinyu.test

class TestArray166 {
    //https://leetcode.cn/problems/surrounded-regions/
    /**
     * 题目描述
    评论 (1.1k)
    题解 (2.2k)
    提交记录
    130. 被围绕的区域
    给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。


    示例 1：


    输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
    解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
    示例 2：

    输入：board = [["X"]]
    输出：[["X"]]


    提示：

    m == board.length
    n == board[i].length
    1 <= m, n <= 200
    board[i][j] 为 'X' 或 'O'

     */

    fun solve(board: Array<CharArray>): Unit {
        //需要换一下思路
        //把所有不能改的标记出来  那么剩下的都是能改的 直接改
        val row = board.size
        val col = board[0].size

        //遍历左右边为O的元素
        for (i in board.indices) {
            dfs(i, 0, board)
            dfs(i, col - 1, board)
        }
        //遍历上下边为O的元素
        for (j in board[0].indices) {
            dfs(0, j, board)
            dfs(row - 1, j, board)
        }

        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == 'A'){
                    board[i][j] = 'O'
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X'
                }
            }
        }

    }

    fun dfs(row: Int, clo: Int, board: Array<CharArray>) {
        if (row >= board.size || clo >= board[0].size || row < 0 || clo < 0) {
            return
        }
        if (board[row][clo] == 'O') {
            board[row][clo] = 'A'
            //左上右下
            dfs(row, clo - 1, board)
            dfs(row - 1, clo, board)
            dfs(row, clo + 1, board)
            dfs(row + 1, clo, board)
        }
    }

}