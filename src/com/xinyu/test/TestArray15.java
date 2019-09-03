package com.xinyu.test;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray15 {

    public static void main(String[] args) {
        System.out.println(reverse(900000));
    }


    /**
     *
     * 整数反转
     给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

     示例 1:

     输入: 123
     输出: 321
     示例 2:

     输入: -123
     输出: -321
     示例 3:

     输入: 120
     输出: 21
     注意:

     假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     *
     *
     *
     */
//    public static int reverse(int x) {
//        int length = 0;
//        int[] arr = new int[32];
//        while (x % 10 != 0 || x != 0){
//            arr[length ++ ] = x % 10;
//            x = x / 10;
//        }
//
//        long result = 0;
//        for (int i = 0; i < length; i++) {
//            result += arr[i] * Math.pow(10,length -1 -i);
//        }
//        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
//            return 0;
//        }else {
//            if (x >>> 31 == 1) {
//                return (int)-result;
//
//            }else {
//                return (int) result;
//
//            }
//        }
//    }


//    public static int reverse(int x) {
//        int ans = 0;
//        while (x != 0){
//            int d = x % 10;
//            x /= 10;
//            if (ans >Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && d > 7)) return 0;
//            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && d < -8)) return 0;
//
//            ans = ans * 10 + d;
//        }
//        return ans;
//    }

    // 被这个算法惊艳到了
    /**
     * 直接逆向思维，就算我不知道原来有多少位都没有关系
     * 每次都是上一次的数*10 加上现在的余数
     * 而且这样的话，不用考虑负数
     * 还有就是判断最大最小值的时候，利用最大值除以10，然后判断余数是不是小于7，因为最大值是‭2147483647‬
     * 除以10 的思想，还是都一样的。
     */
//
    public static int reverse(int x) {
        int result = 0;
        while (x != 0){
            int i = x % 10;
            if (((result > Integer.MAX_VALUE /10) || (result == Integer.MAX_VALUE /10 && i>7) || (result < Integer.MIN_VALUE /10) || (result < Integer.MIN_VALUE /10 && i<8))) {
                return 0;
            }
            result = result * 10 + i;
            x = x /10;
        }

        return  result;
    }

}
