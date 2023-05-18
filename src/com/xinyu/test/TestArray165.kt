package com.xinyu.test

class TestArray165 {
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


        //思路？？？
        //跟围棋好像啊  但是怎么解决呢
        //从不挨着边的位置开始 找一个o  四条边去遍历看是不是都满足条件
        //都满足就可以
        //后面的边只需要告诉我可以不可以
        //可以我就改变自己的值

//        val dp = Array(2) { BooleanArray(3) }
//        for(){
//            for (){
//                if (dp[i][j] != true) {
//
//                }
//
//            }
//        }
    }
//
//    fun dfs() : Boolean{
//        val dp = Array(2) { BooleanArray(3) }
//        if (){
//            return false
//        }
//        for(){
//            for (){
//                if (dp[i][j] != true) {
//                    dfs()
//                    dfs()
//                    dfs()
//                    dfs()
//                     = 'x'
//                    dp[i] = true
//                    return true
//
//                }
//
//            }
//        }
//    }
}