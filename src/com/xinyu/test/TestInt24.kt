package com.xinyu.test

class TestInt24 {
    /**
     * https://leetcode.cn/problems/integer-replacement/
     *
     * 给定一个正整数 n ，你可以做如下操作：

    如果 n 是偶数，则用 n / 2替换 n 。
    如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
    返回 n 变为 1 所需的 最小替换次数 。

     

    示例 1：

    输入：n = 8
    输出：3
    解释：8 -> 4 -> 2 -> 1
    示例 2：

    输入：n = 7
    输出：4
    解释：7 -> 8 -> 4 -> 2 -> 1
    或 7 -> 6 -> 3 -> 2 -> 1
    示例 3：

    输入：n = 4
    输出：2
     

    提示：

    1 <= n <= 231 - 1


    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/integer-replacement
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 边界情况要注意  不然产生了负数  可以一直除下去  导致stackOverFlow
     */
    fun integerReplacementV2(n: Int): Int {
        if (n == 1) return 0
        return if (n % 2 != 0) {
            2 + integerReplacement(n / 2 + 1).coerceAtMost(integerReplacement(n / 2))
        } else{
            1 + integerReplacement(n / 2)
        }
    }

    var map = HashMap<Int,Int>()
    fun integerReplacement(n: Int): Int {
        if (n == 1) return 0
        if (!map.containsKey(n)){
            if (n % 2 != 0) {
                map[n] = 2 + integerReplacement(n / 2 + 1).coerceAtMost(integerReplacement(n / 2))
            } else if (n != 1) {
                map[n] = 1 + integerReplacement(n / 2)
            }
        }
        return map[n]!!
    }
}

fun main() {
    println(TestInt23().integerReplacementV2(8))
}