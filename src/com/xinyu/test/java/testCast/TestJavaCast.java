package com.xinyu.test.java.testCast;

/**
 * Created by zy on 2019/11/19.
 */
public class TestJavaCast {
    public static void main(String[] args) {
//        apple fruit = (apple)getFruit();
        com.xinyu.test.java.testCast.fruit fruit2 = getFruit();
//        apple cast1 = (apple) fruit2;
        apple cast2 = apple.class.cast(fruit2);
//        System.out.println(cast1 == cast2);


    }

    public static fruit getFruit(){
        return new apple();
    }





}

class fruit{

}

class apple extends fruit{

}



