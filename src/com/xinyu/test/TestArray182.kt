package com.xinyu.test

class TestArray182 {
    /**
    https://leetcode.cn/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75
    2352. 相等行列对
    提示
    中等
    85
    相关企业
    给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。

    如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。



    示例 1：



    输入：grid = [[3,2,1],
    [1,7,6],
    [2,7,7]]
    输出：1
    解释：存在一对相等行列对：
    - (第 2 行，第 1 列)：[2,7,7]
    示例 2：



    输入：grid = [
    [3,1,2,2],
    [1,4,4,5],
    [2,4,2,2],
    [2,4,2,2]]
    输出：3
    解释：存在三对相等行列对：
    - (第 0 行，第 0 列)：[3,1,2,2]
    - (第 2 行, 第 2 列)：[2,4,2,2]
    - (第 3 行, 第 2 列)：[2,4,2,2]


    解释是不是写错了？？？？
    最差的方法是：n*n的类比
    重复计算？？
    怎么优化？？？
    可以同样用二维数组标记
    第一行 第一列
    行和行
    列和列

    行和列
    3个数组

    我的题意又理解错了
    我还以为解释写错了

    思路复杂起来
    想起来就复杂 做起来就肯定不简单
    没有办法 Hash表太实用了

     */
    fun equalPairs(grid: Array<IntArray>): Int {
        val map = mutableMapOf<List<Int>, Int>()
        grid.forEach {
            val list = it.toList()
            map[list] = map.getOrDefault(list, 0) + 1
        }
        var result = 0
        for (col in grid.indices) {
            val list = mutableListOf<Int>()
            for (row in grid.indices) {
                list += grid[row][col]
            }
            result+=map.getOrDefault(list,0)
        }
        return result
    }
}