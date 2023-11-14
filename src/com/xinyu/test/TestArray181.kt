package com.xinyu.test

class TestArray181 {
    //https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/
    /**
    https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/

    给你一个二进制数组 nums ，你需要从中删掉一个元素。

    请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。

    如果不存在这样的子数组，请返回 0 。



    提示 1：

    输入：nums = [1,1,0,1]
    输出：3
    解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
    示例 2：

    输入：nums = [0,1,1,1,0,1,1,0,1]
    输出：5
    解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
    示例 3：

    输入：nums = [1,1,1]
    输出：2
    解释：你必须要删除一个元素。


    提示：

    1 <= nums.length <= 105
    nums[i] 要么是 0 要么是 1 。

    其实就是获取最长1的长度
    如果不是等于原来的长度 +1就行？
    不对
    还有两个1合并的情况


    我靠 这我怎么知道删除哪里？？？
    最笨的是一个一个删除
    然后不停的寻找新的数组里面最长1的个数


    dp思想
    当前的数和前一个数有关系就不用重复的遍历了



    优先考虑通用的解决方法
    转变问题的能力需要加强


    转变成最长子序列问题
    其中子序列中0的个数不能超过1

    哎呀 做一遍之后就会了
     */

    fun longestSubarray(nums: IntArray): Int {
        var left = 0
        var right = 0
        var result = 0
        var curCount = 0
        while (right < nums.size) {
            if (nums[right] == 0) {
                curCount++
            }
            while (curCount > 1){
                if (nums[left] == 0){
                    curCount--
                }
                left++
            }
            result = result.coerceAtLeast(right - left)
            right++
        }
        return result
    }
}