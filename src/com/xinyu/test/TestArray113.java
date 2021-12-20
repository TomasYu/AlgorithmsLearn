package com.xinyu.test;

import java.util.Arrays;

public class TestArray113 {

    /**
     * 977. 有序数组的平方
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 已按 非递减顺序 排序
     *
     *
     * 进阶：
     *
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     */

    public int[] sortedSquares(int[] nums) {
        if (nums.length < 1){
            return nums;
        }
        int result[] = new int[nums.length];
        int curIndex = nums.length -1;
        int start = 0,end = nums.length-1;
        while (start <= end){
            if (Math.pow(nums[start],2) >= Math.pow(nums[end],2)) {
                result[curIndex--] = (int) Math.pow(nums[start],2);
                start ++;
            }else {
                result[curIndex--] = (int) Math.pow(nums[end],2);
                end--;
            }
        }
        return result;


    }

    public static void main(String[] args) {
        TestArray113 testArray113 = new TestArray113();
        System.out.println(Arrays.toString(testArray113.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
