package com.xinyu.test;

public class TestNode2 {
    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     * 示例 2：
     *
     *
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     *  
     *
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 500] 内
     * -100 <= Node.val <= 100
     * 0 <= k <= 2 * 109
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode rotateRight(ListNode head, int k) {

        if (k ==0 || head == null || head.next == null) {
            return head;
        }
        //get last  and length
        int length = 1;
        ListNode oldHead = head;
        while (head.next != null) {
            length++;
            head = head.next;
        }

        //compute new last
        int move = length - (k % length);

        if (move == length){
            return oldHead;
        }

        //link to circle
        head.next = oldHead;

        //get head.   set last.next = null
        for (int i = 0; i <  move; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;

    }

    public static void main(String[] args) {

//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        listNode2.next = new ListNode(4);
//        new TestNode2().rotateRight();
    }
}
