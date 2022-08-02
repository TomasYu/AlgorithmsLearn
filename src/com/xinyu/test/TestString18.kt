package com.xinyu.test

class TestString18 {
    /**
     * 97. 交错字符串
    给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。

    两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：

    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
    注意：a + b 意味着字符串 a 和 b 连接。



    示例 1：


    输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    输出：true
    示例 2：

    输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
    输出：false
    示例 3：

    输入：s1 = "", s2 = "", s3 = ""
    输出：true


    提示：

    0 <= s1.length, s2.length <= 100
    0 <= s3.length <= 200
    s1、s2、和 s3 都由小写英文字母组成


    进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?

    https://leetcode.cn/problems/interleaving-string/
     */
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val m = s1.length
        val n = s2.length
        val l = s3.length
        if (m + n != l) {
            return false
        }

        val dp = Array(m + 1) { Array(n + 1) { false } }
        dp[0][0] = true

        dp[0].forEachIndexed { index, b -> if (index > 0) {dp[0][index] = dp[0][index -1 ] && s2[index -1] == s3[index -1] }}
        dp.forEachIndexed { index, booleans -> if (index > 0) {dp[index][0] = dp[index -1][0] && s1[index -1] == s3[index -1]  }}
        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] = dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]
                dp[i][j] = dp[i][j] || (dp[i][j-1] && s2[j-1] == s3[i + j -1])
            }
        }
        dp.forEach { it.forEach { print("$it ") }
            println()
        }
        return dp[m][n]
    }
}

fun main() {
    println(TestString18().isInterleave("aabcc", "dbbca", "aadbbcbcac"))
}