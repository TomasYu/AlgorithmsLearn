package com.xinyu.test

import java.util.ArrayList

class TestList {
    //https://leetcode.cn/problems/permutations/
    /**
    46. 全排列
    中等
    2.7K
    相关企业
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。



    示例 1：

    输入：nums = [1,2,3]
    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    示例 2：

    输入：nums = [0,1]
    输出：[[0,1],[1,0]]
    示例 3：

    输入：nums = [1]
    输出：[[1]]


    提示：

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    nums 中的所有整数 互不相同

     */
    //直接N*N???

    /**
    dfs 搜索这个是
    回溯

    最可恶的是 之前做过
     */
    fun permute(nums: IntArray): List<List<Int>> {

        val list = mutableListOf<List<Int>>()
        for (i in nums.indices) {
            val one = mutableListOf<Int>()
            one.add(nums[i])
            val booleanArray = BooleanArray(nums.size) { false }
            booleanArray[i] = true
            if (one.size == nums.size) {
                list.add(ArrayList(one))
            }
            dfs(nums, list, one, booleanArray, 0)
        }
        return list
    }

    fun dfs(nums: IntArray, list: MutableList<List<Int>>, one: MutableList<Int>, visist: BooleanArray, length: Int) {
        //什么时候开始呢？ 什么时候结束呢？？？

        for (i in nums.indices) {
            if (!visist[i]) {
                visist[i] = true
                one.add(nums[i])
                dfs(nums, list, one, visist, length + 1)
                if (one.size == nums.size) {
                    list.add(ArrayList(one))
                }
                one.remove(nums[i])
                visist[i] = false
            }
        }
    }
}

fun main() {
    println(TestList().permute(intArrayOf(1, 2, 3)))
    println(TestList().permute(intArrayOf(1)))
}