package com.xinyu.test

class TestArray176 {
    /**
    283. 移动零
    提示
    简单
    2.2K
    相关企业
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    请注意 ，必须在不复制数组的情况下原地对数组进行操作。



    示例 1:

    输入: nums = [0,1,0,3,12]
    输出: [1,3,12,0,0]
    示例 2:

    输入: nums = [0]
    输出: [0]


    提示:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1
     */
    fun moveZeroes(nums: IntArray): Unit {
        //第一个为0的
        var left = 0
        //第一个不为0的
        var right = 0
        while (left < nums.size) {
            if (nums[left] == 0) {
                right = left + 1
                while (right < nums.size) {
                    if (nums[right] == 0) {
                        right++
                    } else {
                        nums[left] = nums[right].apply {
                            nums[right] = nums[left]
                        }
                        break
//                        var temp : Int
//                        temp = nums[right]
//                        nums[right] = nums[left]
//                        nums[left] = temp
                    }
                }
            }
            left++
        }
    }


    fun moveZeroes2(nums: IntArray) {
        //left左边是整理好的索引
        var left = 0
        //right 是left 右边当前第一个非0的索引
        var right = 0
        while (right < nums.size) {
            if (nums[right] != 0) {
                nums[left] = nums[right].apply {
                    nums[right] = nums[left]
                }
                left++
                right++
            } else {
                right++
            }
        }
    }
}

class P(var age: Int, var name: String) {}

fun main() {
//    var a = 1
//    var b = 2
//    a = b.apply {
//        b = a
//        println("$b")
//        println("$this")
//    }
//
//    println("$a $b")

    var a = P(22, "a")
    var b = P(28, "b")
    a = b.apply {
        b = a
    }
    println("${a.name} ${b.name}")

    TestArray176().moveZeroes(intArrayOf(0, 1, 0, 3, 12))
}