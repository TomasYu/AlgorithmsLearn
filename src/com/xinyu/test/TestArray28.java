package com.xinyu.test;

/**
 * Created by zy on 2020/4/1.
 */
public class TestArray28 {
    public static void main(String[] args) {
        boolean perfectSquare = isPerfectSquare(808201);
        System.out.println(perfectSquare);
    }


    /**
     *
     *  有效的完全平方数
     给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

     说明：不要使用任何内置的库函数，如  sqrt。

     示例 1：

     输入：16
     输出：True
     示例 2：

     输入：14
     输出：False
     */
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }


        int min = 1,max = num/2,mid;
        while (min <= max){
            mid = (min + max) /2 ;
            //这里注意用long 去接受int
            long i = (long)mid * mid;
            if (i == num) {
                return true;
            }else if (i > num){
                max = mid - 1;
            }else {
                min = mid + 1;
            }
        }

        return false;

    }


}
