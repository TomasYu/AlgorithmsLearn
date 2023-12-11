package com.xinyu.test

class TestArray189 {

    //https://leetcode.cn/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
    /**
    1679. K 和数对的最大数目
    提示
    中等
    66
    相关企业
    给你一个整数数组 nums 和一个整数 k 。

    每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。

    返回你可以对数组执行的最大操作数。



    示例 1：

    输入：nums = [1,2,3,4], k = 5
    输出：2
    解释：开始时 nums = [1,2,3,4]：
    - 移出 1 和 4 ，之后 nums = [2,3]
    - 移出 2 和 3 ，之后 nums = []
    不再有和为 5 的数对，因此最多执行 2 次操作。
    示例 2：

    输入：nums = [3,1,3,4,3], k = 6
    输出：1
    解释：开始时 nums = [3,1,3,4,3]：
    - 移出前两个 3 ，之后nums = [1,4,3]
    不再有和为 6 的数对，因此最多执行 1 次操作。


    提示：

    1 <= nums.length <= 105
    1 <= nums[i] <= 109
    1 <= k <= 109

    其实就是看有几对和为K
    那这样的话 用Map吧
    记录每个数的个数
    然后计算

    has 确实算是个方法
    不用排序了

    当然排序后双指针也肯定是可以的
     */
    fun maxOperations(nums: IntArray, k: Int): Int {
        var map = mutableMapOf<Int, Int>()
        var result = 0
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        nums.forEach {
            if (map[it]!! <= 0) {
                return@forEach
            }
            map[it] = map[it]!! - 1
            if (map.contains(k - it) && map[k - it]!! >= 1) {
                result++
                map[k - it] = map[k - it]!! - 1
            }
        }
        return result
    }
}