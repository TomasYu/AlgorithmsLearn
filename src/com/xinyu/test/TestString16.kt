package com.xinyu.test

class TestString16 {
    /**
     * 392. 判断子序列
    给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

    进阶：

    如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

    致谢：

    特别感谢 @pbrother 添加此问题并且创建所有测试用例。



    示例 1：

    输入：s = "abc", t = "ahbgdc"
    输出：true
    示例 2：

    输入：s = "axc", t = "ahbgdc"
    输出：false


    提示：

    0 <= s.length <= 100
    0 <= t.length <= 10^4
    两个字符串都只由小写字符组成。


    https://leetcode.cn/problems/is-subsequence/solution/pan-duan-zi-xu-lie-dong-tai-gui-hua-by-b-enns/
     */

    /**
     * 我们初始化两个指针 i 和 j，分别指向 s 和 t 的初始位置。每次贪心地匹配，匹配成功则 i 和 j 同时右移，匹配 s 的下一个位置，匹配失败则 j 右移，i 不变，尝试用 t 的下一个字符匹配 s。

    最终如果 i 移动到 s 的末尾，就说明 s 是 t 的子序列。

    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        val m = s.length
        val n = t.length
        while (i < m && j < n){
            if (s[i] == t[i]) {
                i++
            }
            j++
        }
        return i == m
    }
}