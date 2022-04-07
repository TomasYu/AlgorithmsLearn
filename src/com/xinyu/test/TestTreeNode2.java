package com.xinyu.test;

public class TestTreeNode2 {

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     *
     *
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     *
     *
     * 提示：
     *
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序 排列
     * @param args
     */

    public static void main(String[] args) {
        TestTreeNode2 testNode2 = new TestTreeNode2();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode33 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode44 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode33;
        listNode33.next = listNode4;
        listNode4.next = listNode44;
        listNode44.next = listNode5;

        testNode2.deleteDuplicates(listNode);


    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        dummyNode.next = head;
        int dumpNum = -1000;
        while (cur.next != null){
            if (dumpNum != -1000) {
                if (cur.next.val == dumpNum){
                    cur.next = cur.next.next;
                }else {
                    dumpNum = -1;
                }
            }else {
                if (cur.next.next != null && cur.next.val == cur.next.next.val){
                    dumpNum = cur.next.val;
                }else {
                    cur = cur.next;
                }
            }
        }
        return dummyNode.next;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

}
