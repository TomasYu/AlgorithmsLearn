package com.xinyu.test;

/**
 * Created by zy on 2020/3/30.
 */
public class TestArray27 {

    public static void main(String[] args) {
        double v = myPow(2.0, -2147483648);
//        double v = myPow(2.0, 800);
        System.out.println(v);

        double v2 = myPow2(2.0, -2147483648);
//        double v2 = myPow2(2.0, 800);
        System.out.println(v2);

        double v3 = t(2.0, 10);
//        double v2 = myPow2(2.0, 800);
        System.out.println(v3);
    }


    /**
     *
     * Pow(x, n)
     实现 pow(x, n) ，即计算 x 的 n 次幂函数。

     示例 1:

     输入: 2.00000, 10
     输出: 1024.00000
     示例 2:

     输入: 2.10000, 3
     输出: 9.26100
     示例 3:

     输入: 2.00000, -2
     输出: 0.25000
     解释: 2-2 = 1/22 = 1/4 = 0.25
     说明:

     -100.0 < x < 100.0
     n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     *
     */


    /**
     *  这个方法递归用的真好 效率是N 倍
     *
     *
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {

        if (n < 0){
            x = 1/x;
            n = -n;
        }
        return powReverse(x,n);
    }

    private static double powReverse(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double v = powReverse(x, n /2);
        double v1;
        if (n % 2 == 0) {
            v1 = v * v;
        }else {
            v1 = v * v * x;
        }
        return v1;
    }

    public static double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }


    public static double t(double x, int n){
        if (n < 0){
            x = 1/x;
            n = -n;
        }

        return pow(x,n);



    }
    public static double pow(double x ,int n){
        if (n == 0) {
            return 1;
        }

        double pow = pow(x, n / 2);
        double result;
        if (n % 2 == 0) {
            result = pow * pow;
        }else {
            result = pow * pow *x;
        }
        return result;
    }

}
