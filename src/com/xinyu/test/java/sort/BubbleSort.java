package com.xinyu.test.java.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] ints = {10, 2, 7, 3, 9, 5, 20,1};
//        int[] ints = {10, 2, 7};
//        bubbleSort(ints);
        sinkSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        int temp;
        //因为i 是从0 开始  那么需要排序的次数就是 n-1次  因为是0 所以这里是小于这个n-1次
        for (int i = 0 ; i < arr.length -1; i++){
            for (int j = 0; j < arr.length -1 - i; j++ ){
                //比较相邻的两个元素 把最大的挪到最后
                if (arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //下沉排序

    public static void sinkSort(int[] arr){
        int temp;
        //最前面的一个数 是最大或最小的
        for (int i = 0; i < arr.length -1 ; i++){
            //和 i 后面的数  一个个进行比较
            for (int j = i + 1 ; j < arr.length ; j++){
                if (arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
