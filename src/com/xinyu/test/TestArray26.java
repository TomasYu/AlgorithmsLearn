package com.xinyu.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2020/3/29.
 */
public class TestArray26 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        List<Integer> closestElements = findClosestElements(arr, 4, 3);
        System.out.println(closestElements);

    }

    /**
     *
     *
     * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。

     示例 1:

     输入: [1,2,3,4,5], k=4, x=3
     输出: [1,2,3,4]


     示例 2:

     输入: [1,2,3,4,5], k=4, x=-1
     输出: [1,2,3,4]


     说明:

     k 的值为正数，且总是小于给定排序数组的长度。
     数组不为空，且长度不超过 104
     数组里的每个元素与 x 的绝对值不超过 104


     更新(2017/9/19):
     这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
     *
     *[0,0,0,1,3,5,6,7,8,8]
     2
     2
     */

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int length = arr.length;
        int left = 0,right = length -1,mid;

        int mRecent = -1;
        while (left <= right){
            mid = (left + right) /2 ;
            int abs = Math.abs(arr[mid] - x);

            if (mRecent == -1){
                mRecent = mid;
            }

            if (abs <=  Math.abs(arr[mRecent] - x)){
                mRecent = mid;
            }
            if (arr[mid] == x) {
                mRecent = mid;
                break;
            }else if (x > arr[mid]){
                left = mid + 1;
            }else {
                right = mid -1;
            }


        }

        List<Integer> result = new ArrayList<>();
        result.add(arr[mRecent]);

        k--;

        int mleft = mRecent -1 ,mRight = mRecent +1;
        while (k >0){
            if (mleft >= 0 && mRight <=length-1){
                if (Math.abs(x-arr[mleft]) <=Math.abs(x-arr[mRight])) {
                    result.add(0,arr [mleft]);
                    mleft --;
                }else {
                    result.add(arr[mRight]);
                    mRight++;
                }
            }else if (mleft >=0){
                result.add(0,arr[mleft]);
                mleft --;
            }else {
                result.add(arr[mRight]);
                mRight++;

            }
            k--;

        }
        return result;
    }

    /**
     * 比较好的解决方法
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList();
        int start =0;
        int end = arr.length-1;
        while(end - start>=k){
            if(x-arr[start] > arr[end]-x){
                start++;
            }else{
                end--;

            }
        }
        for(int i=start;i<=end;i++){
            res.add(arr[i]);
        }
        return res;
    }

}
