package com.xinyu.test;

public class TestArray67 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(4);
        System.out.println(getIntersectionNode(listNode, listNode2));
    }

    /**
     *
     * @param headB
     * @return
     */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2){
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;

        }
        return node1;
    }
}
