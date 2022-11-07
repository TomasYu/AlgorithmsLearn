package com.xinyu.test

class Test152 {
    /**
     * https://leetcode.cn/problems/maximum-number-of-groups-entering-a-competition/
     * 2358. 分组的最大数量
    给你一个正整数数组 grades ，表示大学中一些学生的成绩。你打算将 所有 学生分为一些 有序 的非空分组，其中分组间的顺序满足以下全部条件：

    第 i 个分组中的学生总成绩 小于 第 (i + 1) 个分组中的学生总成绩，对所有组均成立（除了最后一组）。
    第 i 个分组中的学生总数 小于 第 (i + 1) 个分组中的学生总数，对所有组均成立（除了最后一组）。
    返回可以形成的 最大 组数。



    示例 1：

    输入：grades = [10,6,12,7,3,5]
    输出：3
    解释：下面是形成 3 个分组的一种可行方法：
    - 第 1 个分组的学生成绩为 grades = [12] ，总成绩：12 ，学生数：1
    - 第 2 个分组的学生成绩为 grades = [6,7] ，总成绩：6 + 7 = 13 ，学生数：2
    - 第 3 个分组的学生成绩为 grades = [10,3,5] ，总成绩：10 + 3 + 5 = 18 ，学生数：3
    可以证明无法形成超过 3 个分组。

    3 5 6  7 10 12
    示例 2：

    输入：grades = [8,8]
    输出：1
    解释：只能形成 1 个分组，因为如果要形成 2 个分组的话，会导致每个分组中的学生数目相等。x

    推导过程：
    x(x+1)/2 = n
    x*x + x -2n = 0

    x = ((-1) + Math.sqr(1+8n) )  /  2





    提示：

    1 <= grades.length <= 105
    1 <= grades[i] <= 105



     思路？？

     右边遍历得到距离右边最大的数
     如果不符合条件  就不行

     能不能再分组的标准是右边还比不比刚才这一组大？

     还没有顺序要求！！！

     乱序的话  现排序？

     */

    fun maximumGroups(grades: IntArray): Int {
        val size = grades.size
        return ((-1 + Math.sqrt((1 + 8*size).toDouble())) / 2).toInt()
    }
}

fun main() {
    println(Test152().maximumGroups(intArrayOf(10, 6, 12, 7, 3, 5)))
}