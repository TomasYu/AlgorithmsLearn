package com.xinyu.test;

import java.util.HashSet;

public class TestArray52 {
    public static void main(String[] args) {

    }

    /**
     * 最长连续序列
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     *
     * 要求算法的时间复杂度为 O(n)。
     *
     * 示例:
     *
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int max = 0 ,cur = 0;

        for (Integer integer : hashSet) {
            //只管小的 不管大的
            if (!hashSet.contains(integer-1)) {
                cur = 1;
                while (hashSet.contains(integer+1)){
                    cur ++;
                    integer ++;
                }
                max = Math.max(max,cur);
            }
        }

        return max;
    }
}
