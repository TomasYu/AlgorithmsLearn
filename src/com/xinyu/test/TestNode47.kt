package com.xinyu.test

class TestNode47 {
    /**
     * https://leetcode.cn/problems/insertion-sort-list/
     *
     *
     */
    fun insertionSortList(head: ListNode?): ListNode? {
        var dump = ListNode(-1, head)
        var soreted = head
        var cur = head?.next
        while (cur != null){
            if (cur.`val` > soreted?.`val`!!){
                soreted = cur
                cur = cur.next
            }else{
                var pre = dump
                soreted.next = cur.next

                while (pre.next.`val` < cur.`val`){
                    pre = pre.next
                }
                cur.next = pre.next
                pre.next = cur
                cur = soreted.next
            }
        }
        return dump.next
    }
}

fun main() {
    println(TestNode47().insertionSortList(ListNode(4, ListNode(2, ListNode(1, ListNode(3))))))
}