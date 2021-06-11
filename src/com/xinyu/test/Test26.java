package com.xinyu.test;

import java.util.Arrays;

public class Test26 {
    public static void main(String[] args) {
        int []arr = new int[]{2,-1,4,18,1,3,6,-99};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(isPowOf2(6));

    }

    /**
     *
     *
     * @param arr
     * @param start
     * @param end
     *
     *
     *
     * 快速排序思路：
     *
     * 首先拿数组第一个位置的数，作为基点，比基点大的，直接略过
     *  比基数小的，那么交换位置，并且记住这个位置，因为在这个位置左边，都是比这个基数小的
     *
     *  排序过一遍后，在对当前基数所在的位置的左边和右边分别进行再次的快速排序
     *
     */

    public static void quickSort(int [] arr, int start, int end){


        if (start >= end) {
            return;
        }


        //取cur 作为基数
        int cur = arr[start];
        //记录当前基数位置
        int position = start;
        //循环当前数组
        for (int i = start + 1; i <= end; i++){
            //如果当前数比基数小   那么交换位置
            if (arr[i] < cur) {
                arr[position] = arr[i];
                arr[i] = cur;
                //记录基数最新的位置
                position = i;
            }
        }

        //如果基数位置没有发生变化  那么就说明后面的数 都比第一个大  直接进行右边的排序就好
        if (position == start) {
            quickSort(arr,start + 1,end);
        }else {
            //如果基数位置发生了变化  那么再次按照同样的方法   对数组的左边  和 右边分别进行快排
            quickSort(arr,0,position);
            quickSort(arr,position,end);
        }
    }


    public static boolean isPowOf2(int num){
        return num > 0 && ((num & (num -1)) ==0);
    }





}
