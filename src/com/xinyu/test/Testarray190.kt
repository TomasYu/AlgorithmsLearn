package com.xinyu.test

class Testarray190 {
    //https://leetcode.cn/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75

    /**
    1004. 最大连续1的个数 III
    提示
    中等
    665
    相关企业
    给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。



    示例 1：

    输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    输出：6
    解释：[1,1,1,0,0,1,1,1,1,1,1]
    粗体数字从 0 翻转到 1，最长的子数组长度为 6。
    示例 2：

    输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
    输出：10
    解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    粗体数字从 0 翻转到 1，最长的子数组长度为 10。


    提示：

    1 <= nums.length <= 105
    nums[i] 不是 0 就是 1
    0 <= k <= nums.length


    滑动窗口？？？
    只要不超过k个0就可以
     */
    fun longestOnes(nums: IntArray, k: Int): Int {
        //记录最大值
        //统计当前的0的个数
        //如果超过k个 移动左指针 否则移动右指针
        var max = 0
        var left = 0
        var right = 0
        var curNum = 0
        var curMax = 0
        while (right < nums.size) {
            if (nums[right++] == 0) {
                curNum++
            } else {

            }
            while (curNum > k) {
                if (nums[left++] == 0) {
                    curNum--
                }
            }
            max = max.coerceAtLeast(right - left)

        }

        return max
    }
}