package com.xinyu.test.java.String;

/**
 * Created by zy on 2019/10/24.
 */

class NullTest {
    public static int getInt() {
        return 1;
    }
}
public class StaticTest {
    public static void main(String[] args) {
        NullTest myNullTest = null;
        System.out.println(myNullTest.getInt());
    }
}
