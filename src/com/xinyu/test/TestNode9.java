package com.xinyu.test;

public class TestNode9 {
    /**
     * 返回倒数第 k 个节点
     *
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     *
     * 注意：本题相对原题稍作改动
     *
     * 示例：
     *
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     * 说明：
     *
     * 给定的 k 保证是有效的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        ListNode tail = head;
        int length = 0;
        while (cur != null){
            length ++;
            if (cur.next == null){
                tail = cur;
            }
            cur = cur.next;
        }
        if (tail != null) {
            tail.next = head;
            cur = tail;

            for (int i = 0; i < length - k + 1; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        return -1;

    }

    public int kthToLast2(ListNode head, int k){
        ListNode pre = head,cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null){
            cur = cur.next;
            pre = pre.next;
        }
        return pre.val;
    }
}