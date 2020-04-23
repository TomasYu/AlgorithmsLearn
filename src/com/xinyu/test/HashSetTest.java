package com.xinyu.test;

public class HashSetTest {


    public static void main(String[] args) {

        MyHashSet hashSetTest = new MyHashSet();
        hashSetTest.add(11);
        boolean contains = hashSetTest.contains(11);
        System.out.println(contains);
        hashSetTest.remove(11);
        System.out.println(hashSetTest.contains(11));




    }


    /**
     *   设计哈希集合
     *
     *   不使用任何内建的哈希表库设计一个哈希集合
     *
     * 具体地说，你的设计应该包含以下的功能
     *
     * add(value)：向哈希集合中插入一个值。
     * contains(value) ：返回哈希集合中是否存在这个值。
     * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
     *
     * 示例:
     *
     * MyHashSet hashSet = new MyHashSet();
     * hashSet.add(1);
     * hashSet.add(2);
     * hashSet.contains(1);    // 返回 true
     * hashSet.contains(3);    // 返回 false (未找到)
     * hashSet.add(2);
     * hashSet.contains(2);    // 返回 true
     * hashSet.remove(2);
     * hashSet.contains(2);    // 返回  false (已经被删除)
     *
     * 注意：
     *
     * 所有的值都在 [0, 1000000]的范围内。
     * 操作的总数目在[1, 10000]范围内。
     * 不要使用内建的哈希集合库。
     *
     * //怎么初始化一个数组？ 防止有0元素
     */

    static class MyHashSet {

        private Node[] hasArray;

        /** Initialize your data structure here. */
        public MyHashSet() {
            hasArray = new Node[5000];

        }

        public void add(int key) {
            int i = hash(key);
            if (hasArray[i] == null) {
                hasArray[i] = new Node(key);
            }else {
                Node node = hasArray[i];
                if (node.value == key) {
                    return;
                }else {
                    Node temp = node;
                    while (temp.next !=null){
                        temp = temp.next;
                        if (temp.value == key) {
                            return;
                        }
                    }
                    Node next = new Node(key);
                    temp.next = next;
                    next.pre = temp;
                }
            }

        }

        private int hash(int key) {
            return (key % hasArray.length) & (hasArray.length - 1);
        }

        public void remove(int key) {

            Node node = hasArray[hash(key)];
            while (node != null){
                if (node.value == key) {
                    if (node.pre != null) {
                        node.pre.next = node.next;
                        if (node.next != null) {
                            node.next.pre = node.pre;
                        }
                    }else {
                        hasArray[hash(key)] = node.next;
                        if (node.next != null) {
                            node.next.pre = null;
                        }
                    }
                    return;
                }
                node = node.next;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {

            Node node = hasArray[hash(key)];
            while (node != null){
                if (node.value == key) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        public class Node{
            public Node next;
            public Node pre;
            public int value;
            public Node(int value){
                this.value = value;
            }
        }
    }


    class MyHashSet2 {
        private int[] a;

        public MyHashSet2() {
            int count = 1000001 / 31 + 1;
            a = new int[count];
        }

        public void add(int key) {
            int x = key / 31;
            int y = key % 31;
            a[x] = a[x] | (1 << y);
        }

        public void remove(int key) {
            int x = key / 31;
            int y = key % 31;

            a[x] = (Integer.MAX_VALUE ^ (1 << y)) & a[x];
        }

        public boolean contains(int key) {
            int x = key / 31;
            int y = key % 31;

            return (a[x] & (1 << y)) != 0;
        }


    }


}
