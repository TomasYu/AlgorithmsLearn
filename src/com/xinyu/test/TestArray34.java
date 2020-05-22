package com.xinyu.test;

import java.util.HashSet;
import java.util.Set;

public class TestArray34 {

    public static void main(String[] args) {
        TestArray34 testArray34 = new TestArray34();
        int abcabcbb = testArray34.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }

    /**
     * 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    //第一版本算法
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0,cur = 0;
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            cur = 1;
            characters.clear();
            characters.add(chars[i]);
            for (int j = i+1; j < chars.length; j++) {
                char aChar = chars[j];
                if (characters.contains(aChar)) {
                    max = Math.max(max,cur);
                    break;
                }else {
                    characters.add(aChar);
                }
                cur ++;
            }
            max = Math.max(max,cur);
        }
        return max;
    }
}
