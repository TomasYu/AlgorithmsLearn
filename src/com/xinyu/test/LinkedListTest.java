package com.xinyu.test;

import java.util.LinkedList;

/**
 * Created by zy on 2020/4/4.
 */
public class LinkedListTest {


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.offer(4);
        //最后一个位置插入 相当于offer  add
        linkedList.offerLast(5);
        //offerFirst 在头部插入 相当于add(0,)
        linkedList.offerFirst(0);
        linkedList.add(3,7);

        //删除的是第一个
//        linkedList.remove();
//
//        //stack 取最后一个
//        Integer last = linkedList.pollLast();
//        System.out.println("last" + last);
//
//        //poll 和 pollFirst 是一样的  都是取第一个
//        System.out.println(linkedList.poll());
//        System.out.println(linkedList.pollFirst());


        //队列
//        Integer poll;
//        while ((poll = linkedList.poll()) != null){
//            System.out.println(poll);
//        }

        //栈
        Integer poll2;
        while ((poll2 = linkedList.pollLast()) != null){
            System.out.println(poll2);
        }






    }



    //linkedList poll  是弹出栈顶元素吗？ pollFirst  是栈顶？  polllast 是栈顶
    //add offer 啥区别
    //栈和队列的区别是啥？

}
