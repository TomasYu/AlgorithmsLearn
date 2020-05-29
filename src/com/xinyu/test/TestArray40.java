package com.xinyu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestArray40 {
    public static void main(String[] args) {

    }

    /**
     * 同构字符串
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     *
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * 示例 1:
     *
     * 输入: s = "egg", t = "add"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "foo", t = "bar"
     * 输出: false
     * 示例 3:
     *
     * 输入: s = "paper", t = "title"
     * 输出: true
     * 说明:
     * 你可以假设 s 和 t 具有相同的长度。
     */


    public boolean isIsomorphic(String s, String t) {
        return isIs(s,t) && isIs(t,s);
    }

    public boolean isIs(String s, String t){
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> integers = map.get(chars[i]);
            if (integers == null) {
                integers = new ArrayList<>();
            }
            integers.add(i);
            map.put(chars[i],integers);
        }

        for (int i = 0; i < chars.length; i++) {
            List<Integer> integers = map.get(chars[i]);
            for (Integer integer : integers) {
                if (chars1[i] != chars1[integer]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 很有想法的一个算法
     * 因为char 中 字符的范围是128  所以 两个是256
     * 前128 用来存储 第一个string
     * 后128用来存贮第二个string
     * 然后对比他们的对应关系是否正确
     *
     * 打破传统数组观念
     * 数组本身也是一个map
     * char 因为本身是数字类型 所以可以看做是key
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s.length()==1){
            return true;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        char[] map = new char[256];
        for (int i=cs.length-1;i>=0;i--) {
            if (map[cs[i]] != map[ct[i]+128]) {
                return false;
            }
            map[cs[i]] = map[ct[i]+128] = cs[i];
        }
        return true;
    }
}
