package com.xinyu.test

class TestArray135 {
    /**
     * 1512. 好数对的数目
    给你一个整数数组 nums 。

    如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。

    返回好数对的数目。



    示例 1：

    输入：nums = [1,2,3,1,1,3]
    输出：4
    解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
    示例 2：

    输入：nums = [1,1,1,1]
    输出：6
    解释：数组中的每组数字都是好数对
    示例 3：

    输入：nums = [1,2,3]
    输出：0


    提示：

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    fun numIdenticalPairs(nums: IntArray): Int {
        var result = 0
        nums.forEachIndexed { index, _ ->
            for (j in index + 1 until nums.size) {
                if (nums[j] == nums[index]) {
                    result++
                }
            }
        }
        return result
    }


    fun numIdenticalPairs2(nums: IntArray): Int {
        var result = 0
        var map = HashMap<Int, Int>()
        nums.forEachIndexed { _, i ->
            map[i] = map[i]?.plus(1) ?: 1
        }
        map.values.forEachIndexed { index, i ->
            result += i * (i - 1) / 2
        }
        return result
    }

    fun numIdenticalPairs3(nums: IntArray): Int {
        var result = 0
        var map = HashMap<Int, Int>()
        nums.forEachIndexed { _, i ->
            map[i] = map[i]?.plus(1) ?: 0
            result+= map[i]!!
        }
        return result
    }
}

fun main() {
    println(TestArray135().numIdenticalPairs2(intArrayOf(1, 2, 3, 1, 1, 3)))
}
