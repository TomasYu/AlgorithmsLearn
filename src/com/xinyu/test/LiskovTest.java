package com.xinyu.test;

import java.util.HashMap;
import java.util.Map;

public class LiskovTest {
    public static void main(String[] args) {
        Son son = new Son();
        Object main = son.get(new HashMap());
        System.out.println(main);
        Object son2 = son.get2(new HashMap());
        System.out.println(son2);
    }

}

abstract class Father {
    public Object get(Map a){
        return "father get" + a;
    }

    public Object get2(HashMap a){
        return "father get2" + a;
    }
    public abstract Map get3();
}

class Son extends Father {

    public Object get(HashMap a) {
        return "son " + a;
    }

    public Object get2(Map a){
        return "son get2" + a;
    }
//
//    @Override
//    public Map get3() {
//        return null;
//    }

    @Override
    public HashMap get3(){
        return null;
    }
}
