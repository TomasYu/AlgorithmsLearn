package com.xinyu.test

class TestArray148 {
    /**
     *
     * https://leetcode.cn/problems/arithmetic-slices/
     *
     * 413. 等差数列划分
    如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。

    例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
    给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。

    子数组 是数组中的一个连续序列。



    示例 1：

    输入：nums = [1,2,3,4]
    输出：3
    解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
    示例 2：

    输入：nums = [1]
    输出：0


    提示：

    1 <= nums.length <= 5000
    -1000 <= nums[i] <= 1000


    大于三个就可以 开始计算  每增加一个是等差的话 就新增一个  如果没有了 那就把当前这个加入
    然后寻找新的等差

     */

    fun numberOfArithmeticSlices(nums: IntArray): Int {
        return helper(0, nums.size, nums)
    }

    //数学题 组合
    private fun helper(start: Int, end: Int, nums: IntArray): Int {
        if (start >= end) {
            return 0
        }
        if (end - start < 2) {
            return 0
        }
        var count = 0
        var step = nums[start + 1] - nums[start]
        for (i in start + 1 until end) {
            if (i + 1 < end && nums[i + 1] - nums[i] == step) {
                count++
            } else {
                break
            }
        }
        return count + helper(start + 1, end, nums)
    }

    /***
     * https://leetcode.cn/problems/arithmetic-slices/solution/hua-dong-chuang-kou-dong-tai-gui-hua-jav-3vpp/
     *
     * 没有学到精髓
     */

    fun numberOfArithmeticSlices2(nums: IntArray): Int {
        val size = nums.size
        if (size < 3) {
            return 0
        }
        var result = 0
        var dp = 0
        var i = 0
        var step = 0
        while (i <= size - 1 - 2) {
            step = nums[i + 1] - nums[i]
            while (i < size - 1 && nums[i + 2] - nums[i + 1] == step) {
                dp += 1
                result += dp
                i++
            }
            i++
            dp = 0
        }

        return result
    }

    fun numberOfArithmeticSlices3(nums: IntArray): Int {
        val size = nums.size
        if (size < 3) {
            return 0
        }
        var result = 0
        var dp = 0
        for (i in 2 until size) {
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i -1]){
                dp += 1
                result += dp
            }else{
                dp = 0
            }
        }
        return result
    }
}