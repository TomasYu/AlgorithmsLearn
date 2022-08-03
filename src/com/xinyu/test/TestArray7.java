package com.xinyu.test;

import java.util.Arrays;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray7 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,2,2,3,4}));
        System.out.println(majorityElement2(new int[]{1,2,2,3,4}));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int curNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curNum) {
                count++;
                if (count > nums.length /2) {
                    return curNum;
                }
            }else {
                curNum = nums[i];
                count = 1;
            }
        }
        return curNum;

          //我喜欢的算法
//        int ans = nums[0], count = 1;
//        for(int i = 1; i < nums.length; ++i) {
//            if(count == 0) {
//                count++;
//                ans = nums[i];
//            }
//            else if(nums[i] == ans) {
//                count++;
//            }
//            else {
//                count--;
//            }
//        }
//        return ans;

        //网上最快的算法：
//        Arrays.sort(nums);
//        return nums[nums.length/2];


    }


    public static int majorityElement2(int[] nums) {

        //我喜欢的算法
        int ans = nums[0], count = 1;
        for(int i = 1; i < nums.length; ++i) {
            if(count == 0) {
                count++;
                ans = nums[i];
            }
            else if(nums[i] == ans) {
                count++;
            }
            else {
                count--;
            }
        }
        return ans;

        //网上最快的算法：
//        Arrays.sort(nums);
//        return nums[nums.length/2];


    }
}
