package com.xinyu.test

class TestArray161 {
    //https://leetcode.cn/problems/number-of-provinces/
    /**
     * https://leetcode.cn/problems/number-of-provinces/
     *547. 省份数量
    有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

    省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

    给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

    返回矩阵中 省份 的数量。



    示例 1：


    输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
    输出：2
    示例 2：


    输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
    输出：3


    提示：

    1 <= n <= 200
    n == isConnected.length
    n == isConnected[i].length
    isConnected[i][j] 为 1 或 0
    isConnected[i][i] == 1
    isConnected[i][j] == isConnected[j][i]
     */
    //同一祖先问题？？
    //数组怎么转化成树呢？
    //并查集
    fun findCircleNum(isConnected: Array<IntArray>): Int {

        val size = isConnected.size
        val visit = BooleanArray(size) { false }
        var result = 0
        for (i in visit.indices){
            if (!visit[i]){
                visit[i] = true
                dfs(visit,i,isConnected)
                result ++

            }
        }
        return result
    }

    fun dfs(visit:BooleanArray, i : Int,isConnected: Array<IntArray>){
        for (j in isConnected[i].indices){
            if (isConnected[i][j] == 1) {
                if (!visit[j]){//防止死循环  1-3 3-1
                    visit[j] = true
                    dfs(visit,j,isConnected)
                }
            }
        }
    }
}

fun main() {
    println(
        TestArray161().findCircleNum(
            arrayOf(
                intArrayOf(1, 0, 0, 1),
                intArrayOf(0, 1, 1, 0),
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 0, 1, 1),

                )
        )
    )
}