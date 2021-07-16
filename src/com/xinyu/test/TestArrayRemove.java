package com.xinyu.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayRemove {
    public static void main(String[] args) {


//        remove();
//        remove2();
        remove3();
    }

    private static void remove() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }


        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
            list.remove(i);
        }
    }

    private static void remove2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }


        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }
    }


    private static void remove3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
            list.remove(i);
            size = list.size();
        }
    }

}
