package com.xinyu.test;

public class TestString2 {

    public static void main(String[] args) {
        TestString2 testString2 = new TestString2();
        System.out.println(testString2.checkInclusion("ab", "eidboaoo"));
    }

    /**
     * 字符串的排列
     *
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *
     *
     * 示例2:
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     *
     *
     * 注意：
     *
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
     */

    public boolean checkInclusion(String s1, String s2) {
        //本质是求排列组合
        //abcd
        // abcd  abdc acbd acdb adbc adcd
        //bacd
        //c
        //d

        //纯靠各种情况去拼凑不行
        //使用动态规划
        //从一个到两个
        //a b  c
        //ab  ba
        //abc bac       cba cab acb  bca


        //思路
        /**
         * 首先如果是走求出所有的排列组合之后   再去进行匹配
         * 时间复杂度很高
         *
         * 我们可以用一个26长度的数组  记录s1 和 s2 匹配的个数 count
         * 比如 arr['a']  如果两个字符串都有  那么 count ++
         * 如果count 值为26 说明两个字符串所有的字符个数都是一样的
         * 表示找到了字符串  否则就是没有找到
         *
         * 首先遍历s1 个字符串  找到s1 和 s2 前k（k 为s1的长度）个的匹配度
         */

        if (s1.length() > s2.length()) {
            return false;
        }

        int arr[] = new int[26];
        int arr2[] = new int[26];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            arr [s1.charAt(i) - 'a'] ++;
            arr2 [s2.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == arr2[i]) {
                count++;
            }
        }

        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            if (count == 26) {
                return true;
            }
            if ((++ arr2[s2.charAt(i+s1.length()-1) -'a'] ) == arr[s2.charAt(i+s1.length()-1) -'a']) {
                count++;
            }else if ((arr2[s2.charAt(i+s1.length()-1) -'a'])-1 == arr[s2.charAt(i+s1.length()-1) -'a']){
                count--;
            }

            if ((-- arr2[s2.charAt(i-1) -'a']) == arr[s2.charAt(i-1) -'a']) {
                count++;
            }else if ((arr2[s2.charAt(i-1) -'a']) + 1 == arr[s2.charAt(i-1) -'a']){
                count--;
            }
        }

        return count == 26;

    }


    public class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length())
                return false;
            int[] s1map = new int[26];
            int[] s2map = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                s1map[s1.charAt(i) - 'a']++;
                s2map[s2.charAt(i) - 'a']++;
            }
            int count = 0;
            for (int i = 0; i < 26; i++)
                if (s1map[i] == s2map[i])
                    count++;
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
                if (count == 26)
                    return true;
                s2map[r]++;
                if (s2map[r] == s1map[r])
                    count++;
                else if (s2map[r] == s1map[r] + 1)
                    count--;
                s2map[l]--;
                if (s2map[l] == s1map[l])
                    count++;
                else if (s2map[l] == s1map[l] - 1)
                    count--;
            }
            return count == 26;
        }
    }


}
