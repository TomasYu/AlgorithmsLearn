package com.xinyu.test;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
