package com.xinyu.test

class TestArray164 {
    //https://leetcode.cn/problems/count-servers-that-communicate/
    /**
     *1267. 统计参与通信的服务器
    这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。

    如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。

    请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。



    示例 1：



    输入：grid = [[1,0],[0,1]]
    输出：0
    解释：没有一台服务器能与其他服务器进行通信。
    示例 2：



    输入：grid = [[1,0],[1,1]]
    输出：3
    解释：所有这些服务器都至少可以与一台别的服务器进行通信。
    示例 3：



    输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
    输出：4
    解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。


    提示：

    m == grid.length
    n == grid[i].length
    1 <= m <= 250
    1 <= n <= 250
    grid[i][j] == 0 or 1

     */

        //统计 每一排横竖的数量
        //遍历而为数组就可以
        //不行  还有交叉的情况  可以记录一下
        //还不能斜着往右下走

        //二维数组记录是不是添加过
        //数组中每一个元素  往右扫描 往下扫描一遍
    fun countServers(grid: Array<IntArray>): Int {
        val row = IntArray(grid.size) { 0 }
        val colum = IntArray(grid[0].size) { 0 }

        grid.forEachIndexed { y, ints ->
            ints.forEachIndexed { x, i ->
                if (grid[y][x] == 1){
                    row[y]++
                    colum[x]++
                }
            }
        }

        var result = 0
        grid.forEachIndexed { y, ints ->
            ints.forEachIndexed { x, i ->
                if (grid[y][x] == 1 && (row[y] > 1 || colum[x] > 1)){
                    result++
                }
            }
        }
        return result
    }
}