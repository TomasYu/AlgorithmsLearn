package com.xinyu.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {

    public static void main(String[] args) {

        //不指定comparator 的话，也是会排序的  根据key 的 comparator 方法
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(4);
        queue.add(2);
        queue.add(0);
        System.out.println(queue.toString());



        PriorityQueue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;  正序
                return o2 - o1;   //倒序
            }
        });
        queue1.add(200);
        queue1.add(100);
        System.out.println(queue1);
    }
}
