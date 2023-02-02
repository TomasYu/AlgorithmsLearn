package com.xinyu.test

class TestInt31 {
    /**
     * https://leetcode.cn/problems/smallest-integer-divisible-by-k/
     *
     * 1015. 可被 K 整除的最小整数
    给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。

    返回 n 的长度。如果不存在这样的 n ，就返回-1。

    注意： n 不符合 64 位带符号整数。



    示例 1：

    输入：k = 1
    输出：1
    解释：最小的答案是 n = 1，其长度为 1。
    示例 2：

    输入：k = 2
    输出：-1
    解释：不存在可被 2 整除的正整数 n 。
    示例 3：

    输入：k = 3
    输出：3
    解释：最小的答案是 n = 111，其长度为 3。


    提示：

    1 <= k <= 105

     */

    fun smallestRepunitDivByK(k: Int): Int {
        //思路是什么？？？？
        //不可能一个一个实验  太慢了
        //如果k是偶数 比如 2 肯定不可以
        //有些也是没有的  比如5 感觉只有三 七可以？ 但是没有科学依据
        //但是有多位数的情况  比如11

        if (k % 2 == 0|| k % 5 == 0){
            return -1
        }

        var i = 1
        var result = 1
        while (i % k != 0){
            i %= k
            i = i* 10 + 1
            result++
        }
        return result
    }
    //我没有思考到  我还需要学习  学习之后就会了
}

fun main() {
    println(TestInt31().smallestRepunitDivByK(4))
}