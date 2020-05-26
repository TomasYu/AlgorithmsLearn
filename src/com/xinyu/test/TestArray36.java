package com.xinyu.test;

import java.util.*;

public class TestArray36 {

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    /**
     * 字母异位词分组
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            System.out.println(key);
            List<String> strings = result.get(key);
            if (strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(str);
            result.put(key,strings);
        }
        List<List<String>> list = new ArrayList<>();
        list.addAll(result.values());
        return list;

    }
}
