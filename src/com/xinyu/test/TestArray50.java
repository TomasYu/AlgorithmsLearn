package com.xinyu.test;

import java.util.Arrays;

public class TestArray50 {

    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lengthOfLIS(new int[]{2,2}));
//        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
//        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
//        System.out.println(lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS2(new int[]{2,2}));

    }
    /**
     * 最长上升子序列
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     *
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n2) 。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     */
    public static int lengthOfLIS(int[] nums) {
        int[]arr = new int[nums.length];
        int i = 0,number = 0;
        for (int num : nums) {
            if (number == 0){
                arr[number ] = num;
                number++;
                continue;
            }
            if (num <= arr[number-1]){
                for (int j = 0; j < number; j++) {
                    if (num < arr [j] ) {
                        if ((j > 0 && num >arr[j-1]) || j ==0) {
                            arr[j] = num;
                            break;
                        }
                    }
                }

            }else {
                //放到最后
                arr[number++] = num;
            }
        }
        System.out.println(Arrays.toString(arr));
        return number;
    }

    public static int lengthOfLIS2(int[] nums) {
        int[] arr = new int[nums.length];
        int end = 0;
        for (int num : nums) {
            int start = 0,mid= 0,right = end;
            while (start < right){
                mid = (start + right) /2;
                if (arr[mid] < num) {
                    start = mid + 1;

                }/*else if (arr[mid] == num){
                    break;
                }*/else {
                    right = mid;

                }
            }
//            arr[mid] = num;
            arr[start] = num;
//            if (mid == end) {
            if (right == end) {
                end++;
            }
        }
        return end;
    }


}
