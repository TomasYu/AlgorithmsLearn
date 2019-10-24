package com.xinyu.test.java.String;

/**
 * Created by zy on 2019/10/24.
 */
public class autoboxTest {

    public static void main(String[] args) {
        Short s1 = 1;
        Short s2 = s1;
        s1++;
        System.out.println(s1 == s2);
    }
}
