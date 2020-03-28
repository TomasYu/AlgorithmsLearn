package com.xinyu.test;

import java.util.Arrays;

/**
 * Created by zy on 2020/3/28.
 */
public class TestArray25 {
    /**
     *
     *   在排序数组中查找元素的第一个和最后一个位置
     给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

     你的算法时间复杂度必须是 O(log n) 级别。

     如果数组中不存在目标值，返回 [-1, -1]。

     示例 1:

     输入: nums = [5,7,7,8,8,10], target = 8
     输出: [3,4]
     示例 2:

     输入: nums = [5,7,7,8,8,10], target = 6
     输出: [-1,-1]
     *
     */

    public static void main(String[] args) {
        int [] ar = new int[]{1,2,3};
        int[] ints = searchRange(ar, 1);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] searchRange(int[] nums, int target) {
        int[]result = new int[]{-1,-1};
        int right = nums.length - 1,left = 0,mid = 0;
        boolean hasFind = false;
        while (left <= right){
            mid = (int) (((long) left + right) /2);
            if (target == nums[mid]) {
                hasFind = true;


                break;
            }else if (target >= nums[mid]){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }

        if (hasFind) {
            int mLeft=  mid, mRight =  mid;
            int resultLeft = mid,resultRight = mid;

            for (int j ;left <= mLeft;){
                j = (int) ((((long) mLeft) + left) /2);
                if (nums[j] == target) {
                    mLeft = j -1;
                    resultLeft = j;
                }else {
                    left = j + 1;
                }
            }

            for (int j;mRight <= right;){
                j = (int) ((((long) mRight) + right) /2);
                if (nums[j] == target) {
                    mRight = j +1;
                    resultRight = j;
                }else {
                    right = j - 1;
                }
            }

            result[0] = resultLeft;
            result[1] = resultRight;
        }
        return result;
    }

}
