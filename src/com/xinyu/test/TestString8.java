package com.xinyu.test;

public class TestString8 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("A"));
    }

    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int result = 0;
        for (int i = chars.length -1 ; i >= 0; i--) {
            result += ((chars[i] - 'A' + 1 )* Math.pow(26,chars.length - i -1) );
        }

        return result;
    }
}
