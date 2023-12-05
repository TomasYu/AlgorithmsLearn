package com.xinyu.test

class TestArray185 {
    //https://leetcode.cn/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
    /**
    643. 子数组最大平均数 I
    简单
    327
    相关企业
    给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。

    请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。

    任何误差小于 10-5 的答案都将被视为正确答案。



    示例 1：

    输入：nums = [1,12,-5,-6,50,3], k = 4
    输出：12.75
    解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
    示例 2：

    输入：nums = [5], k = 1
    输出：5.00000


    提示：

    n == nums.length
    1 <= k <= n <= 105
    -104 <= nums[i] <= 104
     */

    fun findMaxAverage(nums: IntArray, k: Int): Double {
        //哎呀 这不简单嘛
        var max:Double
        var left = 0
        var right = 0

        var curValue = 0.0
        while (right < k){
            curValue += nums[right]
            right ++
        }
        max = curValue / k
        while (right < nums.size){
            curValue +=nums[right++]
            curValue-=nums[left++]
            max = max.coerceAtLeast(curValue / k)
        }
        return max
    }
}

fun main() {
    println(-1 / 1)
}