package com.xinyu.test

import kotlin.math.absoluteValue

class TestArray175 {
    //https://leetcode.cn/problems/first-missing-positive/
    /**

    41. 缺失的第一个正数
    提示
    困难
    2K
    相关企业
    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

    请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。


    示例 1：

    输入：nums = [1,2,0]
    输出：3
    示例 2：

    输入：nums = [3,4,-1,1]
    输出：2
    示例 3：

    输入：nums = [7,8,9,11,12]
    输出：1


    提示：

    1 <= nums.length <= 5 * 105
    -231 <= nums[i] <= 231 - 1


    猛一看很简单啊

    先排序？？

    借助map
    从1开始遍历？？
    wocao 跟大哥的思路是一样的

    逻辑思维能力怎么这么枪？？
    一步一步推到的能力？？？

    一步一步推理的能力很重要


    总体看基础技术不够扎实，对业务和技术的目标拆解不够深入，仅仅忙于业务和需求的迭代，预判主观能动性不会太高，不建议推进

    所有的负数 变成正数 然后+N

    遍历 对于num[i]  如果 1..N 把num[num[i] -1]变成负数
    找到第一个不为负数的就是了
    如果没有那就是N+ 1


     面试就是 此处不留爷 自有留爷处
     */

    fun firstMissingPositive(nums: IntArray): Int {
        val size = nums.size
        //最后一个问题 越界？？？
        nums.forEachIndexed { index, i ->
            if (i <= 0) {
               nums[index] = size + 1
            }
        }
        nums.forEachIndexed { index, i ->
            if (i.absoluteValue in 1..size && nums[i.absoluteValue -1]  > 0) {
                nums[i.absoluteValue -1] = -nums[i.absoluteValue -1]
            }
        }

//        有一个问题 我把后面的给变成负数了？
        //咋办？？我自己今天刚看到的题 就忘了 绝对值？？
        nums.forEachIndexed { index, i ->
            if (i >= 0){
                return index + 1
            }
        }

        return size + 1

    }
}

fun main() {
    Int.MIN_VALUE
    println(TestArray175().firstMissingPositive(intArrayOf(-2147483648)))
}