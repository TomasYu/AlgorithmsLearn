package com.xinyu.test

import java.util.*

class TestInt19 {
    /**
     * 2231. 按奇偶性交换后的最大数字
    给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。

    返回交换 任意 次之后 num 的 最大 可能值。



    示例 1：

    输入：num = 1234
    输出：3412
    解释：交换数字 3 和数字 1 ，结果得到 3214 。
    交换数字 2 和数字 4 ，结果得到 3412 。
    注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
    注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
    示例 2：

    输入：num = 65875
    输出：87655
    解释：交换数字 8 和数字 6 ，结果得到 85675 。
    交换数字 5 和数字 7 ，结果得到 87655 。
    注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。


    提示：

    1 <= num <= 109


    https://leetcode.cn/problems/largest-number-after-digit-swaps-by-parity/solution/dao-ge-shua-ti-by-lcfgrn-123y/

    步骤：

    将数字转换为字符串numStr；
    创建2个优先队列，分别存放num中的奇数和偶数，并都以倒序排列；
    按照排好的顺序依次替换原来的奇数或偶数。
     */

    fun largestInteger(num: Int): Int {
        if (num == 0) {
            return 0
        }
        var q1 = PriorityQueue(Collections.reverseOrder<Int>())
        var q2 = PriorityQueue(Collections.reverseOrder<Int>())
        val charArray = num.toString().toCharArray()
        charArray.forEach {
            val value = it - '0'
            when(value % 2){
                0 ->{ q1.offer(value)}
                else ->{q2.offer(value)}
            }
        }
        var result = 0
        charArray.forEach {
            val value = it - '0'
            result = when(value % 2){
                0 ->{
                    result* 10 + q1.poll()
                }
                else ->{
                    result* 10 + q2.poll()
                }
            }
        }
        return result
    }


}

fun main() {
    println(TestInt19().largestInteger(1234))
}