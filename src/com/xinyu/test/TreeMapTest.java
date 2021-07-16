package com.xinyu.test;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapTest {

    public static void main(String[] args) {
//        extracted();


        TreeMap treeMap = new TreeMap();
        treeMap.put("1",2);
        treeMap.put("1",2);
        treeMap.put("1",2);
        treeMap.put("1",2);

        TreeSet treeSet = new TreeSet();
        treeSet.add("aaa");
        treeSet.add("aaa");
        treeSet.add("aaa");
        treeSet.add("aaa");

//        System.out.println(treeMap);;
//        System.out.println(treeSet);


        TreeSet<String> treeSet2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 1 ;
            }
        });
        treeSet2.add("aaa");
        treeSet2.add("bbb");
        treeSet2.add("aaa");
        treeSet2.add("aaa");
        System.out.println(treeSet2);




    }

    private static void extracted() {
        TreeSet treeSetTest = new TreeSet();
        treeSetTest.add(new Object());
        treeSetTest.add(new Object());
        treeSetTest.add(new Object());
    }
}
