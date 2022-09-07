package com.xinyu.test

import kotlin.system.measureTimeMillis

class TestArray141 {
    /**
     * https://leetcode.cn/problems/elimination-game/
     *
     * 390. 消除游戏
    列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：

    从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
    重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
    不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
    给你整数 n ，返回 arr 最后剩下的数字。



    示例 1：

    输入：n = 9
    输出：6
    解释：
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    arr = [2, 4, 6, 8]
    arr = [2, 6]
    arr = [6]
    示例 2：

    输入：n = 1
    输出：1


    提示：

    1 <= n <= 109

     */


    fun lastRemaining(n: Int): Int {
//        val array = IntArray(n) { 1 + it }
//        val toMutableList = array.toMutableList()
        val mutableListOf = mutableListOf<Int>()
        for (i in 0 until n){
            mutableListOf.add(1 + i)
        }
        return helper(mutableListOf, true, mutableListOf())
    }

    fun helper(list: MutableList<Int>, left: Boolean, tempList: MutableList<Int>): Int {
        if (list.size == 1) {
            return list[0]
        }
        tempList.clear()
        if (left) {
            for (i in 1 until list.size step 2){
                tempList.add(list[i])
            }
        } else {
            for (i in list.size -2 downTo 0 step 2){
                tempList.add(list[i])
            }
            tempList.reverse()
        }
        list.clear()
        list.addAll(tempList)
        return helper(list, !left,tempList)
    }


    /**
     * https://leetcode.cn/problems/elimination-game/solution/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-k2uj/
     */
    fun lastRemaining2(n: Int): Int {
        var head = 1
        var step = 1
        var curN = n
        var left = true
        while (curN > 1){
            if (left || curN % 2 == 1){
                head += step
            }
            step *= 2
            curN /= 2
            left = !left
        }
        return head
    }
}

fun main() {
    measureTimeMillis {
        println(TestArray141().lastRemaining2(10000000))
    }.also { println(it) }
    measureTimeMillis {
        println(TestArray141().lastRemaining(10000000))
    }.also { println(it) }
}