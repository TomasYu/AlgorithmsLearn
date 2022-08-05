package com.xinyu.test

class TestInt22 {
    /**
     * 526. 优美的排列
    假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：

    perm[i] 能够被 i 整除
    i 能够被 perm[i] 整除
    给你一个整数 n ，返回可以构造的 优美排列 的 数量 。



    示例 1：

    输入：n = 2
    输出：2
    解释：
    第 1 个优美的排列是 [1,2]：
    - perm[1] = 1 能被 i = 1 整除
    - perm[2] = 2 能被 i = 2 整除
    第 2 个优美的排列是 [2,1]:
    - perm[1] = 2 能被 i = 1 整除
    - i = 2 能被 perm[2] = 1 整除
    示例 2：

    输入：n = 1
    输出：1


    提示：

    1 <= n <= 15

    https://leetcode.cn/problems/beautiful-arrangement/

    https://leetcode.cn/problems/beautiful-arrangement/solution/yi-ti-wu-jie-dfs-bao-sou-ji-yi-hua-dp-zh-qblw/
     */

    fun countArrangement(n: Int): Int {
        //排列 怎么排列？   所有的排列组合都要先列出来 一个个尝试吗？
        return helper(n, 1, 0)

    }

    private fun helper(n: Int, cur: Int, flag: Int): Int {
        if (cur > n){
            return 1
        }
        var result = 0
        for (i in 1..n){
            if ((flag and 1 shl  i == 0) && (cur % i == 0 || i % cur == 0)){
                result += helper(n,cur+1,flag or (1 shl i))
//                println("$cur $i $result")
            }
        }
        return result
    }
}

fun main() {
    println(TestInt22().countArrangement(2))

    var i = 1
    i = i or 2
    i = i xor 2
//    println(i)
}