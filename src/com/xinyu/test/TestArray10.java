package com.xinyu.test;

import java.util.Arrays;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray10 {

    public static void main(String[] args) {
//        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));
        System.out.println(searchMatrix(new int[][]{{}},20));
    }


    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

     每行的元素从左到右升序排列。
     每列的元素从上到下升序排列。
     示例:

     现有矩阵 matrix 如下：

     [
     [1,   4,  7, 11, 15],
     [2,   5,  8, 12, 19],
     [3,   6,  9, 16, 22],
     [10, 13, 14, 17, 24],
     [18, 21, 23, 26, 30]
     ]
     给定 target = 5，返回 true。

     给定 target = 20，返回 false。
     * @return
     */

    public static boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null) {
//            return false;
//        }
//        // y纵向的长度
//        int y = matrix.length;
//        if (y == 0) {
//            return false;
//        }
//        //x 横向的长度
//        int x = matrix[y - 1].length;
//        if (x == 0) {
//            return false;
//        }
//        // 如果小于最小值  大于最大值 那么表示没有
//        if (target < matrix[0][0] || target > matrix[y -1][x-1]){
//            return false;
//        }
//
//        //最快的方式应是对角线查找
//        int curX = 0;
//        int curY = 0;
//        for (; curX < x && curY <y ; curX++,curY++){
//            //对角线
//            if (matrix[curX][curY] == target){
//                return true;
//            }else if (matrix[curX][curY] >target){
//                // 所有这行和这列的数
//                //遍历这行
//                for (int i = 0; i <curX ; i++ ){
//                    if (matrix[curY][i] == target) {
//                        return true;
//                    }
//                }
//                //遍历这列
//                for (int i = 0; i <curY ; i++ ){
//                    if (matrix[i][curX] == target) {
//                        return true;
//                    }
//                }
//
//            }
//        }
//
//        // 横排已经遍历完了  遍历竖排即可
//        if (curX >= x) {
//            for (int i = curY; i < y; i++){
//                for (int j : matrix[i]) {
//                    if (j == target) {
//                        return true;
//                    }
//                }
//            }
//        }
//        // 竖排已经遍历完了  遍历横排即可
//        if (curY >=y){
//            for (int i = curX; i < x; i++){
//                for (int[] aMatrix : matrix) {
//                    if (aMatrix[i] == target) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;


        // 网上最快的方法：
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1;

        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        return false;
    }
}
