package com.xinyu.test;

import java.util.Arrays;

/**
 * Created by zy on 2020/4/3.
 */
public class TestArray30 {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

     例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

     与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */

    public static void main(String[] args) {
        int [] arr = new int[]{-1,2,1,-4};
        int mostRecent = getMostRecent(arr, 1);
        System.out.println(mostRecent);

    }

    public static int getMostRecent(int[] nums,int target){
        if (nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);
        int curMin = nums[0] + nums [1] + nums[2];
        for (int i = 0 ; i < nums.length; i++){
            int start = i + 1,end = nums.length -1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(curMin - target)) {
                    curMin = sum;
                }
                if (sum > target){
                    end--;
                }else if (sum < target){
                    start ++;
                }else {
                    return sum;
                }
            }
        }
        return curMin;
    }

}
