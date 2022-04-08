package com.xinyu.test;

public class TestNode5 {

    public static void main(String[] args) {
        TestNode5 testNode5 = new TestNode5();
        ListNode listNode = new ListNode(2);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode33 = new ListNode(1);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        listNode33.next = listNode4;
        testNode5.getIntersectionNode(listNode,listNode33);
    }

    /**
     * 相交链表
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * <p>
     * 图示两个链表在节点 c1 开始相交：
     * <p>
     * 目数据 保证 整个链式结构中不存在环。
     * <p>
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;

        boolean first = false;
        boolean second = false;

        while (head1 != null && head2 != null) {
            if (head1 == head2){
                return head1;
            }
            if (head1.next != null) {
                head1 = head1.next;
            }else {
                if (!first) {
                    head1 = headB;
                    first = true;
                }else {
                    head1 = null;
                }
            }

            if (head2.next != null) {
                head2 = head2.next;
            }else {
                if (!second){
                    head2 = headA;
                    second = true;
                }else {
                    head2 = null;
                }
            }
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
