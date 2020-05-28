package com.xinyu.test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestArray38 {

    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{1,1,1,2,2,2,3,3,3}, 3);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     *
     * 提示：
     *
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。
     */

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            int value = hashMap.getOrDefault(num, 0) + 1;
            hashMap.put(num, value);
        }
        int[] result = new int[k];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (hashMap.get(o1).equals(hashMap.get(o2))) {
                    return 0;
                }
                return hashMap.get(o1) > hashMap.get(o2) ? 1 : -1;
            }
        });

        for (Integer integer : hashMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(integer);
            }else {
                priorityQueue.add(integer);
                priorityQueue.poll();
            }
        }
        //这一段真的是垃圾  不能这样遍历队列
//        for (int i = 0; i <= priorityQueue.size(); i++) {
//            result[i] = priorityQueue.poll();
//        }
        Integer poll ;
        int i = 0;
        while ((poll = priorityQueue.poll()) != null){
            result[i] = poll;
            i++;
        }
        return result;

    }
}
