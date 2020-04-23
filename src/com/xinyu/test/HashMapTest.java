package com.xinyu.test;

public class HashMapTest {
    public static void main(String[] args) {

    }

    /**
     * 不使用任何内建的哈希表库设计一个哈希映射
     *
     * 具体地说，你的设计应该包含以下的功能
     *
     * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
     * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
     * remove(key)：如果映射中存在这个键，删除这个数值对。
     *
     * 示例：
     *
     * MyHashMap hashMap = new MyHashMap();
     * hashMap.put(1, 1);
     * hashMap.put(2, 2);
     * hashMap.get(1);            // 返回 1
     * hashMap.get(3);            // 返回 -1 (未找到)
     * hashMap.put(2, 1);         // 更新已有的值
     * hashMap.get(2);            // 返回 1
     * hashMap.remove(2);         // 删除键为2的数据
     * hashMap.get(2);            // 返回 -1 (未找到)
     *
     * 注意：
     *
     * 所有的值都在 [0, 1000000]的范围内。
     * 操作的总数目在[1, 10000]范围内。
     * 不要使用内建的哈希库。
     */


    class MyHashMap {

        private Node[] hasArray;


        /** Initialize your data structure here. */
        public MyHashMap() {
            hasArray = new Node[5000];

        }


        private int hash(int key) {
            return (key % hasArray.length) & (hasArray.length - 1);
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int i = hash(key);
            if (hasArray[i] == null) {
                hasArray[i] = new Node(key,value);
            }else {
                Node node = hasArray[i];
                if (node.key == key) {
                    node.value = value;
                }else {
                    Node temp = node;
                    while (temp.next !=null){
                        temp = temp.next;
                        if (temp.key == key) {
                            temp.value = value;
                            return;
                        }
                    }
                    Node next = new Node(key,value);
                    temp.next = next;
                    next.pre = temp;
                }
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {

            Node node = hasArray[hash(key)];
            while (node != null){
                if (node.key == key) {
                    return node.value;
                }
                node = node.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {

            Node node = hasArray[hash(key)];
            while (node != null){
                if (node.key == key) {
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

        public class Node{
            public Node next;
            public Node pre;
            public int value;
            public int key;
            public Node(int key,int value){
                this.key = key;
                this.value = value;
            }
        }
    }
}
