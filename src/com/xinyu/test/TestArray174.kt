package com.xinyu.test

class TestArray174 {
    //https://leetcode.cn/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
    /**
    334. 递增的三元子序列
    中等
    779
    相关企业
    给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。

    如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。



    示例 1：

    输入：nums = [1,2,3,4,5]
    输出：true
    解释：任何 i < j < k 的三元组都满足题意
    示例 2：

    输入：nums = [5,4,3,2,1]
    输出：false
    解释：不存在满足题意的三元组
    示例 3：

    输入：nums = [2,1,5,0,4,6]
    输出：true
    解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6


    提示：

    1 <= nums.length <= 5 * 105
    -231 <= nums[i] <= 231 - 1


    进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？

    这个题有点意思

    到底连续不连续呢？？？
    动态规划去做？
    连续两个
    记录当前最小值 i  curLast j
    x  > i  x = i j ++
    不行

    非要很笨的方法的话
    肯定能做
    但是重复工作量太大了


    思路不对啊

    只记录当前比我大的
    每一步 取最小值

    到底应该什么思路呢？
    来个map
    key
    min length
    你比我小就放进去
    可以还是要遍历一下最小的
    必须可以！！！

    也不对啊

    用单调栈？？？
    队列？？？？


    貌似一遍搞不定啊
    主要是你遇到突然变小的怎么办？
    怎么处理？？

    这道题仿佛做过啊
    方法一感觉好做

    方法二我想到了50% 记录一个数确实不行




     */

    fun increasingTriplet(nums: IntArray): Boolean {
        val size = nums.size
        if (size < 3) {
            return false
        }
        val left = IntArray(size) { Int.MAX_VALUE }
        val right = IntArray(size) { Int.MIN_VALUE }
        left[0] = nums[0]
        right[size - 1] = nums[size - 1]
        //不用考虑等于的情况
        for (i in 1 until size - 1) {
            left[i] = nums[i].coerceAtMost(left[i - 1])
        }

        for (i in size - 2 downTo 1) {
            right[i] = nums[i].coerceAtLeast(right[i + 1])
        }

        for (i in 1 until size - 1) {
            if (nums[i] > left[i] && nums[i] < right[i]){
                return true
            }
        }
        return false
    }
}