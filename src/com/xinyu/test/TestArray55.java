package com.xinyu.test;

import java.util.Arrays;

public class TestArray55 {
    public static void main(String[] args) {
        TestArray55 testArray55 = new TestArray55();
//        char[][] test = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] test = new char[][]{
                {'1','0','1','1','0','1'},
                {'1','1','1','1','1','1'},
                {'0','1','1','0','1','1'},
                {'1','1','1','0','1','0'},
                {'0','1','1','1','1','1'},
                {'1','1','0','1','1','1'}};
        System.out.println(testArray55.maximalSquare(test));
    }

    /**
     * 最大正方形
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     *
     * 示例:
     *
     * 输入:
     *
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * 输出: 4
     */

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int [][] dp = new int[matrix.length][matrix[0].length];
        int maxSide = 0;
        int cur = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                cur = matrix[i][j] == '0' ? 0 : 1;
                if (cur == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = cur;
                    }else {
                        dp[i][j] = cur + Math.min(Math.min(dp[i -1][j],dp[i][j-1]),dp[i-1][j-1]);
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }

//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
        return maxSide * maxSide;

    }
}
