package com.xinyu.test

class TestString26 {
    //https://leetcode.cn/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
    /**
     * https://leetcode.cn/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
     *
     * 1888. 使二进制字符串字符交替的最少反转次数
    给你一个二进制字符串 s 。你可以按任意顺序执行以下两种操作任意次：

    类型 1 ：删除 字符串 s 的第一个字符并将它 添加 到字符串结尾。
    类型 2 ：选择 字符串 s 中任意一个字符并将该字符 反转 ，也就是如果值为 '0' ，则反转得到 '1' ，反之亦然。
    请你返回使 s 变成 交替 字符串的前提下， 类型 2 的 最少 操作次数 。

    我们称一个字符串是 交替 的，需要满足任意相邻字符都不同。

    比方说，字符串 "010" 和 "1010" 都是交替的，但是字符串 "0100" 不是。


    示例 1：

    输入：s = "111000"
    输出：2
    解释：执行第一种操作两次，得到 s = "100011" 。
    然后对第三个和第六个字符执行第二种操作，得到 s = "101010" 。
    示例 2：

    输入：s = "010"
    输出：0
    解释：字符串已经是交替的。
    示例 3：

    输入：s = "1110"
    输出：1
    解释：对第二个字符执行第二种操作，得到 s = "1010" 。


    提示：

    1 <= s.length <= 105
    s[i] 要么是 '0' ，要么是 '1' 。


    https://leetcode.cn/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/solution/zhao-gui-lu-fen-qi-ou-tao-lun-python10xi-aoft/

    终于做完了
    看到上年纪的同事
    我觉得我很牛 他们身体好差
    等我到了那个年纪
    突然发现自己和他们没有什么区别
     */
    fun minFlips(s: String): Int {
        //这题有点难啊 上来就没思路
        //我怎么知道要操作几次操作1 几次操作二最少呢？？？？
        //暴力破解的话 也不是不可以

        //就好像做了一道数学题
        //思路不清晰 不明确
        //看别人写的 真的是很清晰
        //我的思维能力 思考能力不行吗？？？？


        // 1.转换成0101 和 1010 需要的次数关系
        //小算法计算
        //woca 几天下来 都忘了


        //按照101010
        var count = 0
        for (i in s.toCharArray().indices){
            var char = getChar(i)
            if (s[i] != (char)){
                count++
            }
        }
        var result = count.coerceAtMost(s.length - count)


        val s2 = s + s
        for (i in s.indices){

            if (s2[i] != getChar(i)){
                count--
            }
            if (s2[i + s.length] != getChar(i + s.length)){
                count++
            }

            result = result.coerceAtMost(count.coerceAtMost(s.length - count))
        }
        return result
    }

    private fun getChar(i: Int) = if (i % 2 == 1) '0' else '1'
}