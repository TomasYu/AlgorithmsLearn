package com.xinyu.test.java.String;

/**
 * Created by zy on 2019/10/24.
 */
class A
{
    public static int X;
    static { X = InitTest.Y + 1;}
}
public class InitTest
{
    public static int Y = A.X + 1;
    static {}
    public static void main(String[] args) {
        System.out.println("X = "+A.X+", Y = "+InitTest.Y);
    }
}