package com.xinyu.test;

import java.util.Arrays;

public class TestArray53 {
    public static void main(String[] args) {
        numSquares(12);

    }

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     *
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     *
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     */

    public static int numSquares(int n) {
        //思路  使用dp 数组 了解每一个数字 需要的最小的个数
        //然后依次分解每一个数字的最小值

        //我们考虑从下到上   得到每一个数字
        // 这个数组存放每一个数字的最小个数

        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i ;j++){
                min = Math.min(1 + dp[i - j * j],min);
            }
            dp[i] = min;
        }
        System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}
