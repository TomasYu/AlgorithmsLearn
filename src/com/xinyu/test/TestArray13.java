package com.xinyu.test;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray13 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{-1,0,3,8,9,10},new int[]{4,7,12,19,20}));
    }


    /**
     *
     *
     * 寻找两个有序数组的中位数
     给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

     请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

     你可以假设 nums1 和 nums2 不会同时为空。

     示例 1:

     nums1 = [1, 3]
     nums2 = [2]

     则中位数是 2.0
     示例 2:

     nums1 = [1, 2]
     nums2 = [3, 4]

     则中位数是 (2 + 3)/2 = 2.5
     */
//
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length1 = 0,length2 = 0;
//        if (nums1 != null) {
//             length1 = nums1.length;
//        }
//
//        if (nums2 != null) {
//            length2 = nums2.length;
//        }
//
//        if (length1 == 0 ) {
//            if (length2 % 2 == 0) {
//                return (double) (nums2[length2/2] + nums2[length2/2 -1]) / 2;
//            }else {
//                return (double)nums2[length2/2];
//            }
//        }
//
//        if (length2 == 0){
//            if (length1 % 2 == 0) {
//                return (double)(nums1[length1/2] + nums1[length1/2 -1]) / 2;
//            }else {
//                return (double)nums1[length1/2];
//            }
//        }
////        if (nums1[0] > nums2[0]) {
////            return findMedianSortedArrays(nums2,nums1);
////        }
////        int all = length1 + length2;
////        if (all %2 ==0) {
////            return  (double)(nums1[length1 -1] + nums2[0]) / 2;
////        }else {
////            return (double)nums1[length1 -1] < (double)nums2[0] ? (double)nums1[length1 -1] : (double)nums2[0] ;
////        }
//        int arr[] = new int[length1 + length2];
//        for (int i = 0, j = 0 , q = 0;i < length1 || (j < length2);){
//            if (i < length1 && j < length2){
//                if (nums1[i] < nums2[j]) {
//                    arr[q++] = nums1[i++];
//                }else {
//                    arr[q++] = nums2[j++];
//                }
//            }else if (i < length1){
//                arr[q++] = nums1[i++];
//            }else if (j < length2){
//                arr[q++] = nums2[j++];
//            }
//        }
//
//        int all = length1 + length2;
//        if (all % 2 == 0) {
//            return (double)(arr[all/2] + arr[all/2 -1]) / 2;
//        }else {
//            return (double)arr[all/2];
//        }
//
//    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;

        if (length % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, length / 2 + 1);
        }

        int small = findKth(nums1, 0, nums2, 0, length / 2);
        int big = findKth(nums1, 0, nums2, 0, length / 2 + 1);
        return (small + big) / 2.0;
    }


    /**
     *
     * @param nums1 数组1
     * @param index1 表示数组1从第几位开始找
     * @param nums2 数组2
     * @param index2  表示数组2 从第几位开始找
     * @param k  k表示要找第几位，注意k 代表的不是索引，是索引加1
     * @return
     */
    private static int findKth(int[] nums1, int index1, int[] nums2, int index2, int k) {
        // 如果第一个数组查找的位置是末尾，那么说明要找的数据不再数组1里面，那么直接从数组2里面找就可以。
        if (index1 == nums1.length) {
            return nums2[index2 + k - 1];
        }

        // 如果第二个数组查找的位置是末尾，那么说明要找的数据不再数组1里面，那么直接从数组1里面找就可以。
        if (index2 == nums2.length) {
            return nums1[index1 + k - 1];
        }
        //如果要找当前第一位，那么直接返回当前两个数组的最小值
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }

        // 找到第k  位对应的，两个数组的数值  每次排除掉k/2 个数
        int num1 = index1 + k / 2 - 1 < nums1.length ? nums1[index1 + k / 2 - 1] : Integer.MAX_VALUE;
        int num2 = index2 + k / 2 - 1 < nums2.length ? nums2[index2 + k / 2 - 1] : Integer.MAX_VALUE;

        // 如果数组1 的比较小，那么数组1的查找开始位置要往前挪动k/2 个位置（即一下子排除了k/2 个元素），同时要找的位置减去k/2
        //注意 数学里面的k - k / 2  和java 里面的k - k / 2 不是等值的
        if (num1 < num2) {
            return findKth(nums1, index1 + k / 2, nums2, index2, k - k / 2);
        }
        // 如果数组2 的比较小，那么数组2的查找开始位置要往前挪动k/2 个位置（即一下子排除了k/2 个元素），同时要找的位置减去k/2
        return findKth(nums1, index1, nums2, index2 + k / 2, k - k / 2);
    }



}
