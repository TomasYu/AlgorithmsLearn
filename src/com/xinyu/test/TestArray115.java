package com.xinyu.test;

import java.util.ArrayList;
import java.util.List;

public class TestArray115 {
    /**
     * 找到所有数组中消失的数字
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     * 示例 2：
     *
     * 输入：nums = [1,1]
     * 输出：[2]
     *
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 105
     * 1 <= nums[i] <= n
     *
     *进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
     * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int num : nums) {
            int i = (num - 1) % length;
            nums[i] += length;
        }

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= length) {
                integers.add(i+1);
            }
        }
        return integers;
    }

    public static void main(String[] args) {

    }
}
