package com.xinyu.test

import java.util.*

class TestString24 {
    /**
     * 1185. 一周中的第几天
    给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。

    输入为三个整数：day、month 和 year，分别表示日、月、年。

    您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。



    示例 1：

    输入：day = 31, month = 8, year = 2019
    输出："Saturday"
    示例 2：

    输入：day = 18, month = 7, year = 1999
    输出："Sunday"
    示例 3：

    输入：day = 15, month = 8, year = 1993
    输出："Sunday"


    提示：

    给出的日期一定是在 1971 到 2100 年之间的有效日期。
     */

    fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, day)
        val day = calendar.get(Calendar.DAY_OF_WEEK)
        when (day) {
            1 -> {
                return "Sunday"
            }
            2 -> {
                return "Monday"

            }
            3 -> {
                return "Tuesday"

            }
            4 -> {
                return "Wednesday"

            }
            5 -> {
                return "Thursday"

            }
            6 -> {
                return "Friday"

            }
            7 -> {
                return "Saturday"

            }
        }

        return ""

    }


    fun dayOfTheWeek2(day: Int, month: Int, year: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month - 1)
        calendar.set(Calendar.DAY_OF_MONTH, day)
        val day = calendar.get(Calendar.DAY_OF_WEEK)
        when (day) {
            1 -> {
                return "Sunday"
            }
            2 -> {
                return "Monday"

            }
            3 -> {
                return "Tuesday"

            }
            4 -> {
                return "Wednesday"

            }
            5 -> {
                return "Thursday"

            }
            6 -> {
                return "Friday"

            }
            7 -> {
                return "Saturday"

            }
        }

        return ""

    }
}

fun main() {
    TestString24().dayOfTheWeek(31, 8, 2019)
    //如果想设置为某个日期，可以一次设置年月日时分秒，由于月份下标从0开始赋值月份要-1 ，cal.set(year, month, date, hourOfDay, minute, second);

}