package com.xinyu.test;

import java.util.HashSet;

public class TestArray31 {
    public static void main(String[] args) {

    }

    /**
     *   两个数组的交集
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [9,4]
     * 说明:
     *
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        Integer[] integers = set1.toArray(new Integer[0]);
        for (int i = 0; i < integers.length; i++) {
            result[i] = integers[i];
        }
        return result;
    }

}
