package com.xinyu.test

class TestNode11 {
    /**
     * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
     *
     * 数据范围： 0\leq n\leq10000≤n≤1000
     * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
     *
     * 如当输入链表{1,2,3}时，
     * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
     * 以上转换过程如下图所示：
     */
    var tail: ListNode? = null
    fun ReverseList(head: ListNode?): ListNode? {
        revers(head)
        return tail
    }

    fun revers(head: ListNode?): ListNode? {
        // write code here
        if (head == null) {
            return null
        }
        if (head.next != null) {
            revers(head.next)?.next = head;
            head.next = null
        } else {
            tail = head
        }
        return head
    }

    /**
     * 递归
     */
    fun ReverseList2(head: ListNode?): ListNode? {
        // write code here
//        if (head == null || head.next == null) {
        if (head?.next == null) {
            return head
        }
        val tail: ListNode = ReverseList2(head.next)!!
        head.next.next = head
        head.next = null
        return tail
    }


    /**
     *
     */
    fun ReverseList3(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var temp: ListNode?
        var cur: ListNode? = head
        while (cur != null) {
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        }
        return pre
    }

}

fun main() {
    TestNode11().ReverseList(ListNode(1, ListNode(2, ListNode(3))))
}