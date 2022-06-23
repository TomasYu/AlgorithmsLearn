package com.xinyu.test

import java.util.*

class TestArray122 {
    /**
     * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。

    请你返回 任意 一个长度为 k 的整数子序列。

    子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。

     

    示例 1：

    输入：nums = [2,1,3,3], k = 2
    输出：[3,3]
    解释：
    子序列有最大和：3 + 3 = 6 。
    示例 2：

    输入：nums = [-1,-2,3,4], k = 3
    输出：[-1,3,4]
    解释：
    子序列有最大和：-1 + 3 + 4 = 6 。
    示例 3：

    输入：nums = [3,4,3,3], k = 2
    输出：[3,4]
    解释：
    子序列有最大和：3 + 4 = 7 。
    另一个可行的子序列为 [4, 3] 。
     

    提示：

    1 <= nums.length <= 1000
    -105 <= nums[i] <= 105
    1 <= k <= nums.length


    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/find-subsequence-of-length-k-with-the-largest-sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //顺序问题
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        var pair = Array(nums.size) { Array(2) { 0 } }
        nums.forEachIndexed { index, i ->
            run {
                pair[index][0] = nums[index]
                pair[index][1] = index
            }
        }
        Arrays.sort(pair,0,pair.size) { o1, o2 -> if (o1[0] > o2[0]) -1 else 1 }

        Arrays.sort(pair,0,k) { o1, o2 -> if (o1[1] > o2[1]) 1 else -1 }
        var result = IntArray(k)
        for (i in 0 until k){
            result[i] = pair[i][0]
        }
        return result
    }
}

fun main() {
    //怎么创建array?
    println(TestArray122().maxSubsequence(intArrayOf(2, 1, 3, 3), 2).contentToString())
}