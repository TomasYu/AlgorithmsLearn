package com.xinyu.test;

/**
 * Created by zy on 2020/3/26.
 */
public class TestArray21 {
    /**
     *
     * x 的平方根
     实现 int sqrt(int x) 函数。

     计算并返回 x 的平方根，其中 x 是非负整数。

     由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

     示例 1:

     输入: 4
     输出: 2
     示例 2:

     输入: 8
     输出: 2
     说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
     *
     */

    public static void main(String[] args) {
//        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(8));
    }


    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int max = x / 2;
        int min = 1;
        int mid;
        while (min <= max) {
            mid = (max + min) / 2;
            long i = (long)mid * mid;
            if (x == i) {
                return mid;
            }else if (x > i){
                min = mid + 1;
            }else {
                max = mid -1;
            }
        }
        //解释下这里为什么返回max
        //是因为 如果没有找到刚好的平方根
        // 就会发生错位 也就是min 会比 max 大  这时候 min的值因为加过1 所以它的二次方一定比期望的数值大
        //我们可以根据8 来进行思考
        return  max;
    }
}
