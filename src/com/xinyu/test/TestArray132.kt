package com.xinyu.test

class TestArray132 {

    /**
     * 1480. 一维数组的动态和
    给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

    请返回 nums 的动态和。



    示例 1：

    输入：nums = [1,2,3,4]
    输出：[1,3,6,10]
    解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
    示例 2：

    输入：nums = [1,1,1,1,1]
    输出：[1,2,3,4,5]
    解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
    示例 3：

    输入：nums = [3,1,2,10,1]
    输出：[3,4,6,16,17]


    提示：

    1 <= nums.length <= 1000
    -10^6 <= nums[i] <= 10^6
    https://leetcode.cn/problems/running-sum-of-1d-array/
     */

    fun runningSum(nums: IntArray): IntArray {
        val size = nums.size
        val dp = IntArray(size) { 0 }
        nums.forEachIndexed { index, i ->
            if (index == 0) {
                dp[index] = i
            } else {
                dp[index] = dp[index - 1] + i
            }
        }
        return dp
    }

    fun runningSum2(nums: IntArray): IntArray {
        nums.forEachIndexed { index, i ->
            if (index != 0) {
                nums[index] = nums[index - 1] + i
            }
        }
        return nums
    }
}