package com.xinyu.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2019/4/16.
 3
 */
public class TestArray18 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1},1));
    }


    /**
     *
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

     ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

     搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

     你可以假设数组中不存在重复的元素。

     你的算法时间复杂度必须是 O(log n) 级别。

     示例 1:

     输入: nums = [4,5,6,7,0,1,2], target = 0
     输出: 4
     示例 2:

     输入: nums = [4,5,6,7,0,1,2], target = 3
     输出: -1


      78 9246
     *   23478456
     *
     */
    public static int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0,right = length -1,mid;
        while (left <= right){
            mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            }
            //左边有序  这里要有等号  不然 3,1 找1 就有问题
            if (nums[left] <= nums[mid]) {
                //如果在左边有序的里面   后面没有等号是因为  程序走到这里不可能是等号了  上面就返回了
                if (target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else {
                    //另一边去找
                    left = mid + 1;
                }
            }else {
                //右边有序
                //如果在右边的
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    //另一边去找
                    right = mid - 1;
                }

            }
        }

        return  -1;

    }

    public int search2(int[] nums, int target) {
        return search2(nums, 0, nums.length - 1, target);
    }

    private int search2(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < nums[high]) {
            if (nums[mid] < target && target <= nums[high])
                return search2(nums, mid + 1, high, target);
            else
                return search2(nums, low, mid - 1, target);
        } else {
            if (nums[low] <= target && target < nums[mid])
                return search2(nums, low, mid - 1, target);
            else
                return search2(nums, mid + 1, high, target);
        }
    }


}
