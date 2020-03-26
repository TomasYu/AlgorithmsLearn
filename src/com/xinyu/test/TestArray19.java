package com.xinyu.test;

/**
 * Created by zy on 2020/3/26.
 */
public class TestArray19 {
    /**
     *
     * 1,2,3
     * 4,5,6
     * 7,8,9


     有一个二位数组，从左到右，从上到下，都是有序的递增数组
     写一个算法  判断给定数组有没有在这个二位数组里

     提示：从左下角或者右上角开始找


     */
public static void main(String[] args) {
    int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

    boolean b = findTarget(arr, 5);
    System.out.print(b);

}

public static boolean findTarget(int[][] arr , int target){
    if (arr == null) {
        return false;
    }
    int height = arr.length -1;
    int width = arr[0].length -1;

    int i = height,j = 0;
    while ((i >= 0) && (j <= width)){
        if (arr[i][j] == target) {
            return true;
        }else if (target > arr[i][j]){
            j++;
        }else {
            i--;
        }
    }
    return false;

}

}
