package com.xinyu.test

class TestArray184 {
    //https://leetcode.cn/problems/rotting-oranges/?envType=study-plan-v2&envId=leetcode-75
    /**
    https://leetcode.cn/problems/rotting-oranges/?envType=study-plan-v2&envId=leetcode-75
    994. 腐烂的橘子
    中等
    777
    相关企业
    在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

    值 0 代表空单元格；
    值 1 代表新鲜橘子；
    值 2 代表腐烂的橘子。
    每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

    返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。



    示例 1：



    输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
    输出：4
    示例 2：

    输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
    输出：-1
    解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
    示例 3：

    输入：grid = [[0,2]]
    输出：0
    解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。


    提示：

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 10
    grid[i][j] 仅为 0、1 或 2


     十字形传染也很简答
     一个列表放坏了的橘子
     但是我怎么保证一个坏了的橘子只传染一次呢？

     传染完就从集合里面移除
     然后集合里面传染其他的时候，
     先判断是否已经是坏的了
     是的话就不传染

     集合里面没有元素就说明 能够传染的橘子了
     这时候再遍历一遍数据看看是不是全都传染完了就完事了


     集合里面保存的是x,y 数组
     还是得用栈啊

     需要一个二维数组
     不需要

     只需要一个栈就行
     二维数组本身就是一个数据结构

     等等 次数？？？？
     那这样用队列或者arraylist了就得


     */
    fun orangesRotting(grid: Array<IntArray>): Int {
        return 1

    }
}