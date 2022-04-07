package com.xinyu.test;

public class TestTreeNode3 {

    public static void main(String[] args) {

    }

    /**
     * 删除排序链表中的重复元素
     * <p>
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * <p>
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     * <p>
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     * <p>
     * 提示：
     * <p>
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序 排列
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int x = cur.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dumpy.next;

    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

}
