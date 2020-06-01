package com.xinyu.test;

public class TestArray43 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
          {1,  4,  7, 11, 15},
          {2,   5,  8, 12, 19},
          {3,   6,  9, 16, 22},
          {10, 13, 14, 17, 24},
          {18, 21, 23, 26, 30}};

        System.out.println(searchMatrix(arr, 5));
    }

    /**
     * 搜索二维矩阵 II
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     */

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int width = matrix.length;
        int height = matrix[0].length;
        int curW = 0 ,curH = height -1;
        while (curW >= 0 && curW < width && curH >= 0 && curH < height){
            if (matrix[curW][curH] == target) {
                return true;
            }else if (target > matrix[curW][curH]){
                curW ++;
            }else {
                curH --;
            }
        }
        return false;
    }


    public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length  == 0 || matrix[0].length == 0)
            return false;
        int row = 0;
        int column = matrix[0].length - 1;
        while(column >= 0 && row < matrix.length){
            if(matrix[row][column] == target)
                return true;
            else if(target < matrix[row][column])
                column--;
            else if(target > matrix[row][column])
                row++;
        }
        return false;
    }
}
