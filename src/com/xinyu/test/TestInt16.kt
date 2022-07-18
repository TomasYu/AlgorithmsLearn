package com.xinyu.test

class TestInt16 {
    /**
     * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
     *
     *
     * 又一次0到1的机会   怎么搞呢

    示例 1：

    输入: num = 1775(110111011112)
    输出: 8
    示例 2：

    输入: num = 7(01112)
    输出: 4


    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/reverse-bits-lcci
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    https://leetcode.cn/problems/reverse-bits-lcci/solution/dong-tai-gui-hua-you-hua-0ms-by-dralamog-egzo/
     */

    fun reverseBits(num: Int): Int {
        var backUp = num
        val dp = Array(33) { 0 }
        val reverse = Array(33) { 0 }
        var max = 0
        for (i in 1..32) {
            val isNo1 = backUp and 1 == 1
            dp[i] = if (isNo1) dp[i - 1] + 1 else 0
            reverse[i] = if (isNo1) reverse[i - 1] + 1 else dp[i - 1] + 1
            backUp = backUp.shr(1)
            max = max.coerceAtLeast(reverse[i])
        }
        return max
    }
}

fun main() {
    println(TestInt16().reverseBits(2147483647))
}