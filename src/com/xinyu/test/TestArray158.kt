package com.xinyu.test

import java.util.Arrays
import java.util.Comparator

class TestArray158 {
    /**
     * https://leetcode.cn/problems/matchsticks-to-square/
     * 473. 火柴拼正方形
    你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。

    如果你能使这个正方形，则返回 true ，否则返回 false 。



    示例 1:



    输入: matchsticks = [1,1,2,2,2]
    输出: true
    解释: 能拼成一个边长为2的正方形，每边两根火柴。
    示例 2:

    输入: matchsticks = [3,3,3,3,4]
    输出: false
    解释: 不能用所有火柴拼成一个正方形。


    提示:

    1 <= matchsticks.length <= 15
    1 <= matchsticks[i] <= 108

     */

    fun makesquare(matchsticks: IntArray): Boolean {
        //暴力尝试？ 回朔？
        //dp数组 表示当前到最后的总和
        //当选择一个长度 后面的总和不满足 那么肯定不满足
        //因为不能折断 如果循环过程中某条边不满足 那么肯定不满足
        //回朔剪纸简直是程序员必备的 dfs  可能是各种变形

        val sum = matchsticks.sum()
        if (sum % 4 != 0) {
            return false
        }
        val edges = IntArray(4) { 0 }
        //为什么逆序排了一下 效率这么高？
        matchsticks.sortDescending()

        return dfs(0, matchsticks, edges, sum / 4)
    }

    private fun dfs(index: Int, matchsticks: IntArray, edges: IntArray, length: Int): Boolean {
        if (index == matchsticks.size) {
            return true
        }

        for (i in 0..3) {
            if (edges[i] + matchsticks[index] > length) {
                continue
            }
            edges[i] += matchsticks[index]
            if (dfs(index + 1, matchsticks, edges, length)) {
                return true
            }
            edges[i] -= matchsticks[index]
        }

        return false
    }
}

fun main() {
//    println(TestArray158().makesquare(intArrayOf(1, 1, 2, 2, 2)))
    println(TestArray158().makesquare(intArrayOf(3, 3, 3, 3, 4)))
}