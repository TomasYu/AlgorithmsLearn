package com.xinyu.test.java.lamb;

/**
 * Created by zy on 2019/10/25.
 *
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 * One issue with anonymous classes is that if the implementation of your anonymous class is very simple,
 * such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear.
 * In these cases, you're usually trying to pass functionality as an argument to another method, such as what action should be
 * taken when someone clicks a button. Lambda expressions enable you to do this, to treat functionality as method argument,
 * or code as data.

 The previous section, Anonymous Classes, shows you how to implement a base class without giving it a name.
 Although this is often more concise than a named class, for classes with only one method,
 even an anonymous class seems a bit excessive and cumbersome.
 Lambda expressions let you express instances of single-method classes more compactly.
 *
 */
public class LamddaTest {

    interface ClickListerer{
        void onClick(Object o);
    }


    private void click(ClickListerer listerer,Object o){
        listerer.onClick(o);
    }

    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("aaa");
            }
        }.start();

        new Thread(() -> System.out.println("bbb")).start();
        new Thread(() -> {
            System.out.println("ccc");
            System.out.println("ddd");
        }).start();

        LamddaTest lamddaTest = new LamddaTest();
        lamddaTest.click(new ClickListerer() {
            @Override
            public void onClick(Object o) {
                System.out.println("onclick"+o);

            }
        },1);

        lamddaTest.click((Object o) -> System.out.println("lambda onclick"+o),1);
//        lamddaTest.click(new ClickListerer() {
//            @Override
//            public void onClick() {
//                System.out.println("onclick");
//            }
//        });
//
//        lamddaTest.click(()->System.out.println("lambda onclick"));







    }
}
