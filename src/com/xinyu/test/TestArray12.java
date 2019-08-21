package com.xinyu.test;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray12 {

    public static void main(String[] args) {
        ListNode listNodeOne = new ListNode(2);
        ListNode listNodeOne1 = new ListNode(4);
        ListNode listNodeOne2 = new ListNode(3);
        ListNode listNodeOne3 = new ListNode(5);
        listNodeOne.next = listNodeOne1;
        listNodeOne1.next = listNodeOne2;
        listNodeOne2.next = listNodeOne3;
        ListNode listNode = reverseList(listNodeOne);
        System.out.println(listNode);
    }


    /**
     反转一个单链表。

     示例:

     输入: 1->2->3->4->5->NULL
     输出: 5->4->3->2->1->NULL
     进阶:
     你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */


    //实现1
//    public static ListNode reverseList(ListNode head) {
//        ListNode tail = null;
//        while (head != null){
//            ListNode node = new ListNode(head.val);
//            if (tail == null) {
//                tail = node;
//            }else {
//                node.next = tail;
//                tail = node;
//            }
//            head = head.next;
//        }
//        return tail;
//    }

//实现2  我自己写的的递归  太垃圾了。。。。
//    public static ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }else {
//            ListNode newHead = new ListNode(head.val);
//            ListNode listNode = reverseList(head.next);
//            if (listNode != null) {
//                ListNode next = listNode.next;
//                if (next == null) {
//                    listNode.next = newHead;
//                }else {
//                    while (next.next != null){
//                        next = next.next;
//                    }
//                    next.next = newHead;
//                }
//                return listNode;
//            }else {
//                return newHead;
//            }
//        }
//    }


    /**
     * 网上的别人写的  定义了三个容器去保存前一个，当前，和后一个、
     * 首先保存后一个next，然后对当前的节点cur进行操作
     * 然后把当前的cur 的下一个赋值为前一个pre
     * 然后cur 赋值为pre
     * 最后cur 赋值为next
     *
     * @param head
     * @return
     */
//    public static ListNode reverseList(ListNode head) {
//        ListNode current = head;
//        ListNode pre = null;
//        ListNode next;
//        while (current != null) {
//            // 取出 next
//            next = current.next;
//            // 将上一个赋值给 next
//            current.next = pre;
//            // 更改 上一个到当前位置
//            pre = current;
//            // 当前位置往下移动
//            current = next;
//        }
//        return pre;
//    }


    //递归实现
    public static ListNode reverseList(ListNode head) {

        //方法一：
//        ListNode listNode = head;
//        if (head !=null && head.next !=null) {
//            listNode = reverseList(head.next);
//            head.next.next = head;
//            head.next = null;
//        }
//        return listNode;

//        方法二： 递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head);
        head.next.next = head;
        head.next = null;
        return listNode;


    }



    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}
