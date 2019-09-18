package com.xinyu.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2019/4/16.
 */
public class TestInit {
    private int a = -1;
    public static class Holder{
        public Holder() {
            System.out.println("holder init");
        }
    }
    public void b(){
        new Holder();
    }

    public TestInit(int a) {
        System.out.println(this.a);
        this.a = a;
    }

    public static void main(String[] args) {
        new TestInit(2).b();
    }

}
