package com.xinyu.test;

import java.util.HashMap;

public class TestArray54 {

    public static void main(String[] args) {
        TestArray54 testArray54 = new TestArray54();
//        int i = testArray54.longestSubstring("aaabb", 3);
//        System.out.println(i);
        System.out.println(testArray54.longestSubstring("ababacb", 3));
    }

    /**
     * 至少有K个重复字符的最长子串
     * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
     *
     * 示例 1:
     *
     * 输入:
     * s = "aaabb", k = 3
     *
     * 输出:
     * 3
     *
     * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     * 示例 2:
     *
     * 输入:
     * s = "ababbc", k = 2
     *
     * 输出:
     * 5
     *
     * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     */

    public int longestSubstring(String s, int k) {
        //思路：
        /**
         * 首先遍历一遍字符串
         * 使用HashMap 保存所有的数据
         * 再次遍历字符串
         * 如果遇到不满足的字符
         * 那么 可以分割
         *
         * 每次遇到分割 那么就看当前剩余是不是能够满足条件
         *
         */


        char[] chars = s.toCharArray();
        return count(chars,0,chars.length-1,k);
    }

    public int count(char[]chars,int start,int end,int minLength){
        if (end - start  +1 < minLength) {
            return 0;
        }
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = start; i <= end; i++) {
            hashMap.put(chars[i],hashMap.getOrDefault(chars[i],0) + 1);
        }
        while (end -start + 1 > minLength && hashMap.get(chars[start]) < minLength) start++;
        while (end -start + 1 > minLength && hashMap.get(chars[end]) < minLength) end--;
        if (end - start  +1 < minLength) {
            return 0;
        }
        for (int i = start; i <= end; i++) {
            //如果有没有满足的 那么分治
            if (hashMap.get(chars[i]) < minLength) {
                return Math.max(count(chars,start,i-1,minLength),count(chars,i+1,end,minLength));
            }
        }
        return end - start + 1;
    }


}
