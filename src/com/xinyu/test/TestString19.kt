package com.xinyu.test

class TestString19 {
    /**
     * 给你一个二进制字符串 s 。在一秒之中，所有 子字符串 "01" 同时 被替换成 "10" 。这个过程持续进行到没有 "01" 存在。

    请你返回完成这个过程所需要的秒数。

     

    示例 1：

    输入：s = "0110101"
    输出：4
    解释：
    一秒后，s 变成 "1011010" 。
    再过 1 秒后，s 变成 "1101100" 。
    第三秒过后，s 变成 "1110100" 。
    第四秒后，s 变成 "1111000" 。
    此时没有 "01" 存在，整个过程花费 4 秒。
    所以我们返回 4 。
    示例 2：

    输入：s = "11100"
    输出：0
    解释：
    s 中没有 "01" 存在，整个过程花费 0 秒。
    所以我们返回 0 。
     

    提示：

    1 <= s.length <= 1000
    s[i] 要么是 '0' ，要么是 '1' 。
     

    进阶：

    你能以 O(n) 的时间复杂度解决这个问题吗？

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/time-needed-to-rearrange-a-binary-string
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun secondsToRemoveOccurrences(s: String): Int {
        val charArray = s.toCharArray()
        val size = charArray.size
        var result = 0
        while (true) {
            var temp = false
            var index = -1
            for (i in 0 until size) {
                if (charArray[i] == '0' && (i + 1 < size && charArray[i + 1] == '1')) {
                    if (index == i) {
                        continue
                    }
                    temp = true
                    charArray[i] = '1'
                    charArray[i + 1] = '0'
                    index = i + 1
                }
            }
            if (!temp) {
                break
            } else {
                result++
            }
        }

        return result
    }
}

fun main() {
    println(TestString19().secondsToRemoveOccurrences("0110101"))



}