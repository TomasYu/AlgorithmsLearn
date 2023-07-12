package com.xinyu.test

class TestArray169 {
    //https://leetcode.cn/problems/product-of-array-except-self/
    /**
     * 238. 除自身以外数组的乘积
    难度
    中等

    1494





    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

    请不要使用除法，且在 O(n) 时间复杂度内完成此题。



    示例 1:

    输入: nums = [1,2,3,4]
    输出: [24,12,8,6]
    示例 2:

    输入: nums = [-1,1,0,-3,3]
    输出: [0,0,9,0,0]


    提示：

    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内


    进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     */

//    fun productExceptSelf(nums: IntArray): IntArray {
//
//        //想法？？？
//        //n * n
//
//        //dp 重复计算
//
//        //二维数组
//        //0 不带自己的 1是带自己的
//        val array = Array(nums.size) { IntArray(2) }
//        var result = IntArray(nums.size)
//        for (i in nums.indices){
//            if (i > 0){
//                array[i][0] = array[i -1][1]
//                array[i][1] = array[i -1][1] * nums[i]
//            }else{
//
//            }
//        }
//
//        for (i in nums.indices){
//            result[i] = array[i][0]
//        }
//    }


    fun productExceptSelf(nums: IntArray): IntArray {
        var result = IntArray(nums.size)
        result[0] = 1
        for (i in 1 until nums.size) {
            result[i] = result[i - 1] * nums[i - 1]
        }

        var right = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] *= right
            right *= nums[i]
        }
        return result
    }

    //真寄吧  这都没做出来
    //自己做 还是有点问题


}

fun main() {
    println(TestArray169().productExceptSelf(intArrayOf(1, 2, 3, 4)).contentToString())
}