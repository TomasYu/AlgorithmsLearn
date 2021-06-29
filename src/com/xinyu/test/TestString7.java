package com.xinyu.test;

public class TestString7 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(convertToBase72(99999));
        System.out.println(System.nanoTime() - start);
    }

    /**
     * 给定一个整数，将其转化为7进制，并以字符串形式输出。
     *
     * 示例 1:
     *
     * 输入: 100
     * 输出: "202"
     * 示例 2:
     *
     * 输入: -7
     * 输出: "-10"
     */

    public static String convertToBase7(int num) {
        int temp = 0;
        boolean need = num < 0;
        if(num == 0){
            return "0";
        }
        StringBuffer stringBuffer = new StringBuffer();
        num = Math.abs(num);
        while (num != 0 ){
            temp = num % 7;
            stringBuffer.append(temp);
            num = num / 7;

        }
        if (need){
            stringBuffer.append("-");
        }
        return stringBuffer.reverse().toString();
    }

    public static String convertToBase72(int num) {
        if(num<0)
            return "-"+convertToBase72(num*-1);
        if(num<7)
            return num+"";
        return convertToBase72(num/7)+convertToBase72(num%7);

    }

}
