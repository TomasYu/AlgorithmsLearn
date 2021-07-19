package com.xinyu.test;

public class TestString11 {
    public static void main(String[] args) {
        TestString11 testString11 = new TestString11();
//        System.out.println(testString11.strStr("hello", "ll"));
//        System.out.println(testString11.strStr("mississippi", "issip"));
        System.out.println(testString11.strStr("mississippi", "pi"));
    }

    /**
     *

     实现 strStr() 函数。

     给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。



     说明：

     当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

     对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。



     示例 1：

     输入：haystack = "hello", needle = "ll"
     输出：2
     示例 2：

     输入：haystack = "aaaaa", needle = "bba"
     输出：-1
     示例 3：

     输入：haystack = "", needle = ""
     输出：0


     提示：

     0 <= haystack.length, needle.length <= 5 * 104
     haystack 和 needle 仅由小写英文字符组成
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        char[] charArray = haystack.toCharArray();
        char[] chars = needle.toCharArray();

        if (chars.length == 0) {
            return 0;
        }

        char curChar = chars[0];
        int curIndex = 0;
        boolean start = false;

        int result = -1;
        for (int i = 0; i < charArray.length; i++) {

            curChar = chars[curIndex];

            if (start) {
                if (curChar == charArray[i]){
                    curIndex++;
                }else {
                    start = false;
                    i = result;
                    curIndex = 0;
                    result = -1;
                }
            }else {
                if (curChar == charArray[i]) {
                    start = true;
                    result = i;
                    curIndex++;
                }
            }

            if (curIndex > chars.length-1) {
                break;
            }

        }
        if (curIndex != chars.length) {
            result = -1;
        }

        return result;

    }
}
