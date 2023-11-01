package com.xinyu.test

class TestString20 {
    /**
    443. 压缩字符串
    给你一个字符数组 chars ，请使用下述算法压缩：

    从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：

    如果这一组长度为 1 ，则将字符追加到 s 中。
    否则，需要向 s 追加字符，后跟这一组的长度。
    压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。

    请在 修改完输入数组后 ，返回该数组的新长度。

    你必须设计并实现一个只使用常量额外空间的算法来解决此问题。



    示例 1：

    输入：chars = ['a','a','b','b','c','c','c']
    输出：返回 6 ，输入数组的前 6 个字符应该是：['a','2','b','2','c','3']
    解释：'aa' 被 'a2' 替代。'bb' 被 'b2' 替代。'ccc' 被 'c3' 替代。
    示例 2：

    输入：chars = ['a']
    输出：返回 1 ，输入数组的前 1 个字符应该是：['a']
    解释：唯一的组是“a”，它保持未压缩，因为它是一个字符。
    示例 3：

    输入：chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b']
    输出：返回 4 ，输入数组的前 4 个字符应该是：['a','b','1','2']。
    解释：由于字符 'a' 不重复，所以不会被压缩。'bbbbbbbbbbbb' 被 “b12” 替代。


    提示：

    1 <= chars.length <= 2000
    chars[i] 可以是小写英文字母、大写英文字母、数字或符号


    整体思路是：
    curChar curCount
    if(curChar != charAt){
    }else{
    计算
    }

    12的字符串长度是多少？
    100的字符长度怎么计算？？？
    如果>0 不停的/10
    就可以知道他的长度了


    int怎么转成char??
    1+'0'



     */
    fun compress(chars: CharArray): Int {
        var curChar: Char? = null
        var result = 0
        var sameFirst = true
        var sameCount = 1
        var index = 0
        for (char in chars) {
            curChar?.let {
                index++
                if (char == curChar) {
                    sameCount++
                    if (sameFirst) {
                        result++
                        sameFirst = false
                    }
                    if (sameCount >= 10 && ((index + 1) >= chars.size || index + 1 < chars.size && chars[index + 1] != curChar)) {
                        val toCharArray = sameCount.toString().toCharArray()
                        for (c in toCharArray) {
                            chars[result] = c
                            result++
                        }
                        result--
                    } else {
                        chars[result] = '0' + sameCount
                    }
                } else {
                    sameFirst = true

                    sameCount = 1
                    result++
                    chars[result] = char
                    curChar = char
                }
            } ?: let {
                curChar = char
            }
        }
        return result + 1
    }

    /**
     * 三指针
     * 滑动窗口
     */
    fun compress2(chars: CharArray): Int {
        //左边
        var left = 0
        //总长度（最新的位置）
        var result = 0
        //right 右边窗口索引
        for (right in 0..chars.size) {
            //如果到达末尾  或者不一致的字符  更新
            if (right == chars.size || chars[left] != chars[right]) {
                chars[result++] = chars[left]
                if (right - left > 1) {
                    "${right - left}".toCharArray().forEach {
                        chars[result++] = it
                    }
                }
                left = right
            }
        }
        return result
    }


    fun compress3(chars: CharArray): Int {
        //左边
        var left = 0
        //总长度（最新的位置）
        var result = 0
        //right 右边窗口索引
        for (right in 0..chars.size) {
            //如果到达末尾  或者不一致的字符  更新
            if (right == chars.size || chars[left] != chars[right]) {
                chars[result++] = chars[left]
                var length = right - left
                var start = result
                if (length > 1) {
                    while (length > 0) {
                        chars[result++] = '0' + length % 10
                        length /= 10
                    }
                }
                reverse(chars, start, result - 1)
                left = right
            }
        }
        return result
    }

    fun reverse(chars: CharArray, leftIndex: Int, rightIndex: Int) {
        var left = leftIndex
        var right = rightIndex
        var temp: Char
        while (left < right) {
            temp = chars[right]
            chars[right] = chars[left]
            chars[left] = temp
            left++
            right--
        }
    }
}

fun main() {
//    println(66.toChar())
//    println('0' + 66)
//    val chars = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    val chars = charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')
    println(TestString20().compress3(chars))
    println(chars.concatToString())


}

//                    chars[result -1] = sameCount.toChar()
//                    chars[result -1] = '0' + sameCount
/**

1.char  int.toChar 2.toChar  '0' + 2
2.100 变成1  0   0
3.


滑动窗口
https://leetcode.cn/problems/string-compression/solution/hua-dong-chuang-kou-fa-ya-suo-zi-fu-chuan-java-by-/



 */