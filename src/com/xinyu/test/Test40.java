package com.xinyu.test;

import java.util.*;

public class Test40 {

    public static void main(String[] args) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(3000,2);
        treeMap.put(1,2);
        treeMap.put(200,4);
        System.out.println(true);
        firstUniqChar("leetcode");


        List<Integer> list = new ArrayList<>();
//        list.add(0);
        list.add(0,1);
        System.out.println(Arrays.toString(list.toArray()));


    }

    /**
     * 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 案例:
     *
     * s = "leetcode"
     * 返回 0.
     *
     * s = "loveleetcode",
     * 返回 2.
     *
     *
     * 注意事项：您可以假定该字符串只包含小写字母。
     */
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
//        TreeMap<Character,Integer> treeMap = new TreeMap<>(new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return 0;
//            }
//        });
        HashMap<Character,Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar,map.getOrDefault(aChar,0)+1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
