package com.xinyu.test;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray1 {

    public static void main(String[] args) {
        ListNode listNodeOne = new ListNode(2);
        ListNode listNodeOne1 = new ListNode(4);
        ListNode listNodeOne2 = new ListNode(3);
        listNodeOne.next = listNodeOne1;
        listNodeOne1.next = listNodeOne2;

        ListNode listNodeTwo = new ListNode(5);
        ListNode listNodeTwo1 = new ListNode(6);
        ListNode listNodeTwo2 = new ListNode(4);
        listNodeTwo.next = listNodeTwo1;
        listNodeTwo1.next =listNodeTwo2;
        ListNode listNode = addTwoNumbers(listNodeOne, listNodeTwo);
        System.out.println(listNode);
    }


    /**
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

     示例：

     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/add-two-numbers
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     * @return
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curNode = null;
        int addPlus = 0;
        do {
            int val1 = l1 !=null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int result = (val1 + val2 + addPlus) % 10;
            addPlus = (val1 + val2 + addPlus ) /10;
            ListNode node = new ListNode(result);
            if (head == null) {
                head = node;
                curNode = head;
            }else {
                curNode.next = node;
                curNode = node;
            }
            l1 = l1 !=null ? l1.next : null;
            l2 = l2 !=null ? l2.next : null;
        }while (l1 != null || l2 != null || addPlus != 0);

        return head;
    }


 static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
}
