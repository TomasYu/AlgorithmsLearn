package com.xinyu.test.java.String;

/**
 * Created by zy on 2019/10/24.
 *
 *finally 不管是不是有异常都会走
 * 就算是return 也会走
 */


public class Finalytest {
    public static void main(String[] args) {
        test1();
        test2();

        System.out.println(Integer.parseInt("1"));
        System.out.println(Integer.parseInt("2"));
    }

    private static void test1() {
        try{
            int a = 10 / 0 ;
            System.out.println("1");
            return;
        }catch (Exception e){
            System.out.println("2");
            return;
        }finally {
            System.out.println("3");
        }
    }


    private static void test2() {
        try{
            int a = 3 / 2 ;
            System.out.println("1");
            return;
        }catch (Exception e){
            System.out.println("2");
            return;
        }finally {
            System.out.println("3");
        }
    }
}
