package com.xinyu.test

class TestString22 {
    /**
     * 557. 反转字符串中的单词 III
    给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。



    示例 1：

    输入：s = "Let's take LeetCode contest"
    输出："s'teL ekat edoCteeL tsetnoc"
    示例 2:

    输入： s = "God Ding"
    输出："doG gniD"


    提示：

    1 <= s.length <= 5 * 104
    s 包含可打印的 ASCII 字符。
    s 不包含任何开头或结尾空格。
    s 里 至少 有一个词。
    s 中的所有单词都用一个空格隔开。
    https://leetcode.cn/problems/reverse-words-in-a-string-iii/
     */
//    fun reverseWords(s: String): String {
//        val length = s.length
////        val sb = StringBuffer()
////        sb.append()
//        var lastIndex = length - 1
//        val result = CharArray(length) { ' ' }
//        for (i in length - 1 downTo 0) {
//            if (s[i] != ' ') {
//                result[length - 1 - i] = s[i]
//            } else {
//
//            }
//
//
//        }
//        return String(result)
//    }

    fun reverseWords(s: String): String {
        val split = s.split(" ").toMutableList()
        split.forEachIndexed { index, s ->
            split[index] = s.reversed()
        }
        return split.joinToString(" ")
    }
}

fun main() {

}