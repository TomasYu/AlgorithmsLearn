package com.xinyu.test

/**
 * 剑指 Offer 25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000
 *
 */


fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var dump = ListNode(-1)
    var cur: ListNode? = dump
    var node1 = l1
    var node2 = l2
    while (node1 != null && node2 != null) {
        if (node1.`val` > node2.`val`) {
            cur?.next = node2
            node2 = node2.next
        } else {
            cur?.next = node1
            node1 = node1.next
        }
        cur = cur?.next
    }
    cur?.next = node1 ?: node2
    return dump.next
}


fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
    return if (l1 == null){
        l2
    }else if (l2 == null){
        l1
    }else if (l1.`val` > l2.`val`){
        l2.next = mergeTwoLists2(l1,l2.next)
        l2
    }else{
        l1.next = mergeTwoLists2(l1.next,l2)
        l1
    }
}
