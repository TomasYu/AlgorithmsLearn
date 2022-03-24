package com.xinyu.test;

import java.util.*;

public class TestLruCache {

    /**
     * https://leetcode-cn.com/problems/lru-cache-lcci/
     */


    // wrong

    /**
     * 输入：
     * ["LRUCache","get","put","get","put","put","get","get"]
     * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
     * 输出：
     * [null,-1,null,-1,null,null,2,-1]
     * 预期结果：
     * [null,-1,null,-1,null,null,2,6]
     */
    class LRUCacheWrong {
        LinkedHashMap<Integer,Integer> map;
        int capacity;
        public LRUCacheWrong(int capacity) {
            map = new LinkedHashMap<Integer,Integer>(capacity, 0.75f,true);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)){
                return map.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.size() == capacity) {
                Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
                Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
                Map.Entry<Integer, Integer> next = null;
                if (iterator.hasNext()) {
                    next = iterator.next();
                }

                if (next != null) {
                    map.remove(next.getKey());
                }
            }
            map.put(key,value);
        }
    }



    class LRUCache {

        class Node{
            public Node pre;
            public Node nex;
            public int value;
            public Node(int value){
                this.value = value;
            }
        }
        //
        Map map ;
        Node head,tail;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap(capacity);
            head = new Node(-1);
            tail = new Node(-1);
            head.nex = tail;
            tail.pre = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            // have
            if (map.containsKey(key)) {
                // find key
                Node node = findKey(key);
                //move to head
                moveToFirst(node);
                //get value
                return (int) map.get(key);
            }else {
                // not contains return -1
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                //find
                Node node = findKey(key);
                // to head
                moveToFirst(node);
                map.put(key,value);
            }else {
                if (map.size() > capacity) {
                    //remove last
                    Node pre = tail.pre;
                    Node node = pre.pre;
                    node.nex = tail;
                    tail.pre = node;
                    // put new
                    putNew(key, value);
                    map.remove(pre.value);
                }else {
                    putNew(key, value);
                }
            }
        }

        private void putNew(int key, int value) {
            // put new
            Node node = new Node(key);
            map.put(key, value);
            //move to head
            moveToFirst(node);
        }


        public Node findKey(int key){
            // find key
            Node cur = head.nex;
            //LinkedHashMap 也这样查找吗？
            while (cur != null) {
                if (cur.value == key) {
                    return cur;
                }
                cur = cur.nex;
            }
            return null;
        }

        public void moveToFirst(Node node){

            //if  is head
            if (head.nex == node) {
                return;
            }

            // 衔接node
            if (node.pre != null){
                Node pre1 = node.pre;
                Node nex1 = node.nex;
                pre1.nex = nex1;
                nex1.pre = pre1;
            }



            Node pre = head.nex;
            head.nex = node;
            node.pre = head;

            node.nex = pre;
            pre.pre = node;
        }
    }


}
