package com.xinyu.test.java.String;

/**
 * Created by zy on 2019/10/24.
 */
public class StringTransactTest {

    public static void main(String[] args) {
        String a = "a";
        String b = new String("b");

        changeString(a);
        changeString(b);

        int number = 23;
        changeNum(number);

        int number1 = 10;
        Integer integer11 = 10;
        Integer integer12 = 10;


        int number2 = 1000;
        Integer integer21 = 1000;
        Integer integer22 = 1000;


        System.out.println(a);
        System.out.println(b);
        System.out.println(number);

        System.out.println(number1 == integer11);
        System.out.println(integer11 == integer12);

        System.out.println(number2 == integer21);
        System.out.println(integer21 == integer22);
    }

    private static void changeString(String a) {
        a = new String("changed");
    }

    private static void changeNum(int number){
        number = 20;
    }

}
