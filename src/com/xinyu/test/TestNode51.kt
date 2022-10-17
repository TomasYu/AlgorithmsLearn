package com.xinyu.test

class TestNode51 {
    /**
     * 1758. 生成交替二进制字符串的最少操作数
    给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。

    交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。

    返回使 s 变成 交替字符串 所需的 最少 操作数。



    示例 1：

    输入：s = "0100"
    输出：1
    解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
    示例 2：

    输入：s = "10"
    输出：0
    解释：s 已经是交替字符串。
    示例 3：

    输入：s = "1111"
    输出：2
    解释：需要 2 步操作得到 "0101" 或 "1010" 。


    提示：

    1 <= s.length <= 104
    s[i] 是 '0' 或 '1'

    https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/


    怎么才能是最少次数呢？
    只有两种情况  1变  2变
    取最小就可以？ 还有不变呢  如果2种一样就可以不变 就是0
    思路是错的


    看了思路做出来了  但是说实话还是挺绕的

     */
    fun minOperations(s: String): Int {
        //
        val charArray = s.toCharArray()
        if (charArray.size == 1) {
            return 0
        }
        var one = 0
        var cur = charArray[0]
        for (i in 1 until charArray.size) {
            cur = if (cur == '1') '0' else '1'
            if (cur != charArray[i]) {
                one++
            }
        }

        var two = 1
        cur = if ('1' == charArray[0]) '0' else '1'
        for (i in 1 until charArray.size) {
            cur = if (cur == '1') '0' else '1'
            if (cur != charArray[i]) {
                two++
            }
        }
        return one.coerceAtMost(two)
    }

    /**
     * https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/solution/liang-chong-qing-kuang-bi-da-xiao-xiao-d-1bbp/
     */
    fun minOperations2(s: String): Int {
        //
        val charArray = s.toCharArray()
        var ji = 0
        var ou = 0
        for (i in charArray.indices) {
            if ((charArray[i] - '0') % 2 == i % 2) {
                ji++
            } else {
                ou++
            }
        }
        return ji.coerceAtMost(ou)
    }
}

fun main() {
    println(TestNode51().minOperations("10010100"))
}