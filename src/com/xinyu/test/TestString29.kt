package com.xinyu.test

class TestString29 {
    /**
    https://leetcode.cn/problems/longest-palindromic-substring/

    5. 最长回文子串
    提示
    中等
    6.9K
    相关企业
    给你一个字符串 s，找到 s 中最长的回文子串。

    如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。



    示例 1：

    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：

    输入：s = "cbbd"
    输出："bb"


    提示：

    1 <= s.length <= 1000
    s 仅由数字和英文字母组成
     */


    /**
    思路？？？？
    如果直接按照题意去写  可能会不是很好写

    很明显直接回溯
    不停更新最长的哪个回文串即可
    不需要回溯
    双重for 就可以搞定吧？
    但是怎么高效判断一个字符串是回文串？
    只能是记录开始结束位置 然后遍历对比？？？
    差不多是n^3


    假如是动态规划
    那因该是二维数组 i j

    初始化：
    dp[i][i] == true
    dp[i][i + 1]

    一次循环怎么写？
    [i] [j ++ ]
    动态规划的循环方向是反的

    不能只会太简单的遍历
    动态规划 都是从少到多
    把大问题分解为小问题

     */
    fun longestPalindrome(s: String): String {
        var start = 0
        var end = 1

        val length = s.length
        val charArray = s.toCharArray()
        val booleanArray = Array(length) {
            BooleanArray(length) { false }
        }

        for (i in 0 until length) {
            booleanArray[i][i] = true
        }

        for (i in 2..length) {
            for (j in 0..length) {
                if (i == 2) {
                    if (j + 1 < length) {
                        booleanArray[j][j + i - 1] = charArray[j] == charArray[j + 1]
                    }
                } else {
                    if (j + i - 1 < length) {
                        booleanArray[j][j + i - 1] =
                            booleanArray[j + 1][j + i - 2] and (charArray[j] == charArray[j + i - 1])
                    }
                }

                if (j + i - 1 < length && booleanArray[j][j + i - 1] && (i > end - start)) {
                    end = j + i
                    start = j
                }
            }
        }

        return s.substring(start, end)
    }
}