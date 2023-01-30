package com.xinyu.test

class TestString25 {
    /**
     * https://leetcode.cn/problems/consecutive-characters/
     *
     * 1446. 连续字符
    给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。

    请你返回字符串 s 的 能量。



    示例 1：

    输入：s = "leetcode"
    输出：2
    解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
    示例 2：

    输入：s = "abbcccddddeeeeedcba"
    输出：5
    解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。


    提示：

    1 <= s.length <= 500
    s 只包含小写英文字母。

     */

    fun maxPower(s: String): Int {
        //遍历一遍  记录最大的长度
        val charArray = s.toCharArray()
        var start = charArray[0]
        var max = 0
        var cur = 1
        for (i in 1 until charArray.size) {
            if (start == charArray[i]) {
                cur++
                max = max.coerceAtLeast(cur)
            } else {
                cur = 1
                start = charArray[i]
            }
        }
        return max
    }

    fun maxPower2(s: String): Int {
        val charArray = s.toCharArray()
        var max = 1
        var cur = 1
        for (i in charArray.indices) {
            if (i != charArray.size - 1 && s[i] == s[i + 1]) {
                cur++
                max = max.coerceAtLeast(cur)
            } else {
                cur = 1
            }
        }
        return max
    }
}