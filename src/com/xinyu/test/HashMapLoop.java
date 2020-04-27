
package com.xinyu.test;

import java.util.HashMap;
import java.util.UUID;

public class HashMapLoop {
    public static void main(String[] args) {
        //书上说  这样会死循环  但是其实没有
        final HashMap<String,String> map = new HashMap<>(2);
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> map.put(UUID.randomUUID().toString(),""),"ftf" + i).start();
            }

        },"ftf");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
