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

    一定要明白start 和 end的含义

     */
    fun longestPalindrome(s: String): String {
        var start = 0
        var end = 1

        val size = s.length
        val charArray = s.toCharArray()
        val dpArray = Array(size) {
            BooleanArray(size) { false }
        }

        for (i in 0 until size) {
            dpArray[i][i] = true
        }
        //i 表示字串的长度
        for (length in 2..size) {
            //j 表示字串的起始位置
            for (startIndex in 0 until size) {
                val endIndex = startIndex + length - 1
                if (endIndex >= size) {
                    break
                }
                //长度是2
                if (length == 2) {
                    if (startIndex + 1 < size) {
                        dpArray[startIndex][endIndex] = charArray[startIndex] == charArray[startIndex + 1]
                    }
                } else {
                    //长度是3以上
                    if (endIndex < size) {
                        dpArray[startIndex][endIndex] =
                            dpArray[startIndex + 1][startIndex + length - 2] && charArray[startIndex] == charArray[endIndex]
                    }
                }

                if (dpArray[startIndex][endIndex] && length > end - start) {
                    start = startIndex
                    end = startIndex + length
                }
            }
        }

        return s.substring(start, end)
    }
}