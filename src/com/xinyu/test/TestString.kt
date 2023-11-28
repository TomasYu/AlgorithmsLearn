package com.xinyu.test

import java.util.*

class TestString {
    //https://leetcode.cn/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
    /**
    1657. 确定两个字符串是否接近
    提示
    中等
    74
    相关企业
    如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：

    操作 1：交换任意两个 现有 字符。
    例如，abcde -> aecdb
    操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
    例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
    你可以根据需要对任意一个字符串多次使用这两种操作。

    给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。



    示例 1：

    输入：word1 = "abc", word2 = "bca"
    输出：true
    解释：2 次操作从 word1 获得 word2 。
    执行操作 1："abc" -> "acb"
    执行操作 1："acb" -> "bca"
    示例 2：

    输入：word1 = "a", word2 = "aa"
    输出：false
    解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
    示例 3：

    输入：word1 = "cabbba", word2 = "abbccc"
    输出：true
    解释：3 次操作从 word1 获得 word2 。
    执行操作 1："cabbba" -> "caabbb"
    执行操作 2："caabbb" -> "baaccc"
    执行操作 2："baaccc" -> "abbccc"
    示例 4：

    输入：word1 = "cabbba", word2 = "aabbss"
    输出：false
    解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。


    提示：

    1 <= word1.length, word2.length <= 105
    word1 和 word2 仅包含小写英文字母

    操作一和操作二的顺序不影响结果
    怎么证明呢？

    挪位置是不是可以忽略？？
    还真不能忽略啊
    服了 是在不行直接排序
    其实是每个元素的个数一致就一定可以

    其实就是1个元素的个数
    2个元素的个数
    这种能对上就可以
    所以两次遍历

    key
    a 1
    1 1
    这样肯定是可以的
    但是如果要问几步可以操作出来
    那真的挺难的

    但是同样是1个元素
    a和c其实是不行的

    //treeMap是根据key排序的
     */
    fun closeStrings(word1: String, word2: String): Boolean {
        val map1 = TreeMap<Int, Int> { o1, o2 -> o1 - o2 }
        val map2 = TreeMap<Int, Int> { o1, o2 -> o1 - o2 }
        word1.forEach {
            val key = it - 'a'
            map1[key] = map1.getOrDefault(key, 0) + 1
        }
        word2.forEach {
            val key = it - 'a'
            map2[key] = map2.getOrDefault(key, 0) + 1
        }
        for (i in 0..26) {
            if (!map1.contains(i).xor(map2.contains(i))) {
                continue
            }
            return false
        }


        val intOne = map1.values.toIntArray().also { it.sort() }
        val intTwo = map2.values.toIntArray().also { it.sort() }
        return intOne.contentEquals(intTwo)

    }


    /**
     * 没啥好说的
     * 有时候map真没数组好用
     */
    fun closeStrings2(word1: String, word2: String): Boolean {
        val countArray1 = IntArray(26) { 0 }
        val countArray2 = IntArray(26) { 0 }

        word1.forEach {
            val key = it - 'a'
            countArray1[key] = countArray1[key] + 1
        }
        word2.forEach {
            val key = it - 'a'
            countArray2[key] = countArray2[key] + 1
        }

        for (i in 0 until 26) {
            if (countArray1[i] + countArray2[i] == 0) {
                continue
            }
            if (countArray1[i] == 0 || countArray2[i] == 0) {
                return false
            }
        }
        Arrays.sort(countArray1)
        Arrays.sort(countArray2)
        return countArray1.contentEquals(countArray2)

    }
}

fun main() {
//    println(TestString().closeStrings("cabbba", "abbccc"))
    println(TestString().closeStrings2("abc", "bca"))
    //xor 是啥？ 同或怎么表达？？？
    //
    println(!true.xor(false))
    println(!true.xor(true))
    println(!false.xor(false))
}