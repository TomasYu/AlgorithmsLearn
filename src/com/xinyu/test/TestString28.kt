package com.xinyu.test

class TestString28 {
    /**
    https://leetcode.cn/problems/string-to-integer-atoi/

    8. 字符串转换整数 (atoi)
    中等
    1.7K
    相关企业
    请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

    函数 myAtoi(string s) 的算法如下：

    读入字符串并丢弃无用的前导空格
    检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
    读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
    将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
    如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
    返回整数作为最终结果。
    注意：

    本题中的空白字符只包括空格字符 ' ' 。
    除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。


    示例 1：

    输入：s = "42"
    输出：42
    解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
    第 1 步："42"（当前没有读入字符，因为没有前导空格）
    ^
    第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
    ^
    第 3 步："42"（读入 "42"）
    ^
    解析得到整数 42 。
    由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
    示例 2：

    输入：s = "   -42"
    输出：-42
    解释：
    第 1 步："   -42"（读入前导空格，但忽视掉）
    ^
    第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
    ^
    第 3 步："   -42"（读入 "42"）
    ^
    解析得到整数 -42 。
    由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
    示例 3：

    输入：s = "4193 with words"
    输出：4193
    解释：
    第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
    ^
    第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
    ^
    第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
    ^
    解析得到整数 4193 。
    由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。


    提示：

    0 <= s.length <= 200
    s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成


    最怕理解不对题意
    写个代码 九九八十一难

    原来是自动机思想

    这他妈也叫代码？
     */

    fun myAtoi(s: String): Int {
        //简单 从前开始计算值 前面的值*10 + 后面的值就可以了
        val charArray = s.toCharArray()
        val autoMaton = AutoMaton()
        for (c in charArray) {
            if (autoMaton.getNextState(c) == State.End) {
                break
            }
        }

        return autoMaton.result.toInt()
    }
}

enum class State {
    Start,
    Symbol,
    ReadNumber,
    End
}

class AutoMaton {
    private var map = mutableMapOf<State, MutableList<State>>()
    private var curState = State.Start
    var result: Long = 0L
    private var fushu = false

    init {
        //+- 空格 数字 其他
        map.put(State.Start, mutableListOf(State.Symbol, State.Start, State.ReadNumber, State.End))
        map.put(State.Symbol, mutableListOf(State.End, State.End, State.ReadNumber, State.End))
        map.put(State.ReadNumber, mutableListOf(State.End, State.End, State.ReadNumber, State.End))
        map.put(State.End, mutableListOf(State.End, State.End, State.End, State.End))
    }

    fun getNextState(c: Char): State {
        curState = map[curState]!![getCharIndex(c)]
        when (curState) {
            State.Start -> {}
            State.Symbol -> {
                // 0 * -1???
                fushu = c == '-'
            }

            State.ReadNumber -> {
                //竟然让一个负数给我难住了 真蔡了当时
                result = if (fushu) {
                    (result * 10 - (c - '0')).coerceAtLeast(Int.MIN_VALUE.toLong())
                } else {
                    (result * 10 + (c - '0')).coerceAtMost(Int.MAX_VALUE.toLong())
                }
            }

            State.End -> {
            }
        }
        return curState
    }

    //+- 空格 数字 其他
    private fun getCharIndex(c: Char): Int {
        when (c) {
            '+', '-' -> {
                return 0
            }

            ' ' -> {
                return 1
            }

            in '0'..'9' -> {
                return 2
            }

            else -> {
                return 3
            }
        }
    }


}

fun main() {
    println(TestString28().myAtoi("9223372036854775808"))
    println(TestString28().myAtoi("42"))
    println(TestString28().myAtoi("-42"))
    println(TestString28().myAtoi("words and 987"))
    println(TestString28().myAtoi("4193 and 987"))
    println(Int.MIN_VALUE.toLong())
}