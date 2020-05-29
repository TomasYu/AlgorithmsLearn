package com.xinyu.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestArray41 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1,2,3}, 2));
    }
    /**
     * 存在重复元素 II
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     *
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> integers = map.get(nums[i]);
            if (integers == null) {
                integers = new LinkedList<>();
            }
            integers.add(i);
            map.put(nums[i],integers);
        }

        for (Map.Entry<Integer, LinkedList<Integer>> integerListEntry : map.entrySet()) {
            LinkedList<Integer> value = integerListEntry.getValue();
            for (int i = 0,j = 1; i < value.size() && j < value.size() ; i++,j++) {
                if (Math.abs(value.get(i)-value.get(j)) <= k) {
                    return true;
                }

            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i]) - i) <= k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        for(int i=1;i<nums.length;i++)
            for(int j=i-1;j>=0;j--){
                if (nums[i] > nums[j]) {
                    break;
                } else if(nums[j]==nums[i]&&(i-j<=k)) return true;
            }
        return false;
    }

}
