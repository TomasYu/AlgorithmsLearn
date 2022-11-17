package com.xinyu.test

class TestArray155 {
    /**
     * https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/
     * 1523. 在区间范围内统计奇数数目
    给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。



    示例 1：

    输入：low = 3, high = 7
    输出：3
    解释：3 到 7 之间奇数数字为 [3,5,7] 。
    示例 2：

    输入：low = 8, high = 10
    输出：1
    解释：8 到 10 之间奇数数字为 [9] 。


    提示：

    0 <= low <= high <= 10^9
    //正常思路  有一个问题就是太慢了

    //数学方法？？？/
    直接两个数之间的数的个数 / 2
    再加上左右两边是不是奇数

    找规律

    起始位置是奇数  1 + 后面个数 / 2
    起始位置是偶数  0 +  后面个数 / 2 +  余数

     */

    fun countOdds(low: Int, high: Int): Int {
        return if (low % 2 == 0) {
            (high - low) / 2 + (high - low) % 2
        } else {
            1 + (high - low) / 2
        }

    }


    //前缀和
    fun countOdds2(low: Int, high: Int): Int {
        return pre(high) - pre(low - 1)

    }

    //从0 到x 的奇数个数
    fun pre(x: Int): Int {
        return (x + 1) /2
    }
}

fun main() {
    println(TestArray155().countOdds(8, 10))
}