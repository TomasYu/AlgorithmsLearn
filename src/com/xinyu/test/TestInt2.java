package com.xinyu.test;

public class TestInt2 {
    public static void main(String[] args) {
        System.out.println(gcd(2, 4));
        System.out.println(gcd(3, 4));
        System.out.println(gcd(8, 4));
    }

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}
