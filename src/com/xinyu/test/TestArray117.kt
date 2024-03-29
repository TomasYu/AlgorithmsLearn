package com.xinyu.test

import java.util.*
import kotlin.collections.ArrayList

class TestArray117 {
    /**
     * https://leetcode.cn/problems/pascals-triangle/
     *
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

    在「杨辉三角」中，每个数是它左上方和右上方的数的和。



     

    示例 1:

    输入: numRows = 5
    输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    示例 2:

    输入: numRows = 1
    输出: [[1]]
     

    提示:

    1 <= numRows <= 30


    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/pascals-triangle
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun generate(numRows: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()

        for (i in 0 until numRows) {
            val list = ArrayList<Int>()
            for (j in 0 .. i) {
                if (j == 0 || j == i) {
                    list.add(1)
                } else {
                    val element = result[i - 1]
                    list.add(element[j - 1] + element[j])
                }
            }
            result.add(list)
        }
        return result
    }

}

fun main() {
    val generate = TestArray117().generate(10)
    generate.forEach { list -> println(list.toString()) }
}