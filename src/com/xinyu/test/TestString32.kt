package com.xinyu.test

class TestString32 {
    //https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
    /**
    https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
    1456. 定长子串中元音的最大数目
    提示
    中等
    83
    相关企业
    给你字符串 s 和整数 k 。

    请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。

    英文中的 元音字母 为（a, e, i, o, u）。



    示例 1：

    输入：s = "abciiidef", k = 3
    输出：3
    解释：子字符串 "iii" 包含 3 个元音字母。
    示例 2：

    输入：s = "aeiou", k = 2
    输出：2
    解释：任意长度为 2 的子字符串都包含 2 个元音字母。
    示例 3：

    输入：s = "leetcode", k = 3
    输出：2
    解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
    示例 4：

    输入：s = "rhythms", k = 4
    输出：0
    解释：字符串 s 中不含任何元音字母。
    示例 5：

    输入：s = "tryhard", k = 4
    输出：1


    提示：

    1 <= s.length <= 10^5
    s 由小写英文字母组成
    1 <= k <= s.length
     */
    fun maxVowels(s: String, k: Int): Int {
        val charSet = setOf('a', 'e', 'i', 'o', 'u')
        val length = s.length
        var left = 0
        var right = 0
        var curResult = 0
        var result = 0
        while (left < length && right < length) {
            while (right - left < k){
                if (s[right++] in charSet) {
                    curResult++
                }
            }
            result = result.coerceAtLeast(curResult)
            while (right - left >= k){
                if (s[left++] in charSet){
                    curResult--
                }
            }
        }
        return result
    }
}

fun main() {
    println(TestString32().maxVowels("abciiidef", 3))
}