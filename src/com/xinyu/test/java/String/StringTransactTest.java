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

        System.out.println(a);
        System.out.println(b);
        //输出是a b  因为调用changeString 的时候，我们传递的是String 对象在
//        内存中的应用，调用changeString方法的时候，会复制一份引用的值到参数栈里面，
//        在changeString方法里面,changeString 的参数变量又被重新赋值为另一个string 对象，
//        方法结束，方法外面的变量a指向的内存地址一直都没有改变过，所以，打印出来还是a.

        int number = 23;
        changeNum(number);
        System.out.println(number);
//        打印是23，因为java 是值传递，基本数据类型会复制一份到方法栈中，在方法里面改变局部变量的值
// 不会影响外面的值。

        int number1 = 10;
        Integer integer11 = 10;
        Integer integer12 = 10;


        System.out.println(number1 == integer11);
        System.out.println(integer11 == integer12);
        //第一个是true number1 是基本数据类型，而integer11 是对象类型。他们两个比较的时候，
//        会发生自动拆箱，integer11 拆箱之后为基本数据类型，然后比较，肯定是相等的。
//    第二个是true 是因为Integer  直接这样写，相当于Integer.valueOf(),而这个类有缓存机制的。
//     -127-128之间的数字会被缓存   当是同一个数字的时候，会直接返回同一个对象，所以，两个比较是true

        int number2 = 1000;
        Integer integer21 = 1000;
        Integer integer22 = 1000;

        System.out.println(number2 == integer21);
        System.out.println(integer21 == integer22);

        //第一个是true 和上面一样
//    第二个是false 是因为Integer  是因为1000已经超过了默认的缓存机制，就会去new 对象，new 的两个对象肯定会相当。

        Integer integer31 = new Integer(1000);
        Integer integer32 = new Integer(1000);
        System.out.println(integer31 == integer32);
        //两个new 的对象，在堆分配了不同的内存，所以内存地址不同 false

    }

    private static void changeString(String a) {
        a = new String("changed");
    }

    private static void changeNum(int number){
        number = 20;
    }

}
