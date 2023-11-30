package com.xinyu.test

class TestString34 {
    //https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
    /**

    1071. 字符串的最大公因子
    提示
    简单
    371
    相关企业
    对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。

    给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。



    示例 1：

    输入：str1 = "ABCABC", str2 = "ABC"
    输出："ABC"
    示例 2：

    输入：str1 = "ABABAB", str2 = "ABAB"
    输出："AB"
    示例 3：

    输入：str1 = "LEET", str2 = "CODE"
    输出：""


    提示：

    1 <= str1.length, str2.length <= 1000
    str1 和 str2 由大写英文字母组成

    思路：
    感觉就是有的话
    也是其中一个字符串


    没有想到很巧妙的
    两个字符串
    先找到端的
    从1开始到最长
    不停的看能不能作为共因子
    是的话
    不停的更新最长的共因子值

    https://zhuanlan.zhihu.com/p/346479426?ivk_sa=1024320u
    https://blog.csdn.net/wzx15927662183/article/details/90212839
    最大公约数算法

    没想到最后可以转成数学问题
    真的是
     */
    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 + str2 == str2 + str1) {
            val gcd = gcd(str1.length, str2.length)
            return str1.substring(0, gcd)
        } else {
            return ""
        }

    }

    fun gcd(x: Int, y: Int): Int {
        if (y == 0) {
            return x
        } else {
            return gcd(y, x % y)
        }
    }
}