package com.xinyu.test;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray11 {

    public static void main(String[] args) {
        System.out.println(findPeakElement2(new int[]{1,2,3,1}));
        System.out.println(findPeakElement2(new int[]{1,2,3,8,7,9,20,2,9,1}));
    }


    /**
     * 峰值元素是指其值大于左右相邻值的元素。

     给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

     数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

     你可以假设 nums[-1] = nums[n] = -∞。

     示例 1:

     输入: nums = [1,2,3,1]
     输出: 2
     解释: 3 是峰值元素，你的函数应该返回其索引 2。
     示例 2:

     输入: nums = [1,2,1,3,5,6,4]
     输出: 1 或 5
     解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
     说明:

     你的解法应该是 O(logN) 时间复杂度的。
     */

    public static int findPeakElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
            for (int i = 0; i < nums.length ; i++) {
                if (i != 0 || i != nums.length-1) {
                    if (nums[i-1] < nums[i] &&  nums[i] > nums[i+1]) {
                        return i;
                    }
                }
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }

        return maxIndex;
    }


    /**
     * 比较佩服的写法，因为只要求找一个峰值，所以不必一个一个遍历
     * @param nums
     * @return
     */
    public static int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }


}
