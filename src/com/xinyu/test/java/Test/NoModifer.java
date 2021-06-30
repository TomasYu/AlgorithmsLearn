package com.xinyu.test.java.Test;

public class NoModifer {
    //没有修饰符  默认为包内可见
    int age = 10;

    private NoModifer(){

    }

    private void test(){}

    public class NoModifer2 extends NoModifer{

        public void test2(){
            NoModifer.this.test();
        }
    }

}
