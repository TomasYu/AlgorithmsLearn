package com.xinyu.test

import java.net.URLDecoder
import java.net.URLEncoder
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
        val visited = BooleanArray(nums.size) { false }
        val curList = mutableListOf<Int>()
        dfs(nums, list, curList, visited)
        return list
    }

    fun dfs(nums: IntArray, list: MutableList<List<Int>>, curList: MutableList<Int>, visited: BooleanArray) {
        //成功后保存快照
        //经典回溯
        for (i in nums.indices) {
            if (!visited[i]) {
                visited[i] = true
                curList.add(nums[i])
                dfs(nums, list, curList, visited)
                if (curList.size == nums.size) {
                    list.add(ArrayList(curList))
                }
                curList.remove(nums[i])
                visited[i] = false
            }
        }
    }
}

fun main() {
    println(TestList().permute(intArrayOf(1, 2, 3)))
    println(TestList().permute(intArrayOf(1)))
    println(
        URLDecoder.decode(
            "{\"extra\":\"{\\\"FILE_HASH\\\":\\\"7BVz75MBX8HSm+PNo6yNlVyu1titpIrAMkYZ4A0mwzY=\\\",\\\"FILE_SIZE\\\":\\\"893629651\\\",\\\"androidBuildVariant\\\":\\\"userdebug\\\",\\\"METADATA_HASH\\\":\\\"n3Z0lcNwy6mKnkxiKKTpqoFQ3372XQ0cdFJ3EBHsqpw=\\\",\\\"METADATA_SIZE\\\":\\\"101648\\\"}\",\"checksum\":\"fc79c1709e35182034e9f9f18ea0b765\",\"version\":\"2.0.107\",\"url\":\"http://10.142.117.1/download/mico/x8f/daily/2.0.107-userdebug/payload_2.0.107_0b765.bin\",\"hardware\":\"X8F\"}",
            "UTF-8"
        )
    )

    //源字符串：7BVz75MBX8HSm+PNo6yNlVyu1titpIrAMkYZ4A0mwzY=
    //直接解码
    println(URLDecoder.decode("7BVz75MBX8HSm+PNo6yNlVyu1titpIrAMkYZ4A0mwzY=","UTF-8"))

    //解码
    println(URLDecoder.decode("7BVz75MBX8HSm%20PNo6yNlVyu1titpIrAMkYZ4A0mwzY%3D","UTF-8"))


    //先编码
    println(URLEncoder.encode("7BVz75MBX8HSm+PNo6yNlVyu1titpIrAMkYZ4A0mwzY=","UTF-8"))
    //后解码
    println(URLDecoder.decode("7BVz75MBX8HSm%2BPNo6yNlVyu1titpIrAMkYZ4A0mwzY%3D","UTF-8"))




    //https://tools.fun/url.html
}