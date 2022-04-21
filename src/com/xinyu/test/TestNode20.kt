package com.xinyu.test

import java.util.*

/**
 *
 * 19. 删除链表的倒数第 N 个结点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。



示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]


提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var dump = ListNode(-1)
    dump.next = head
    var pre = dump

    var slow = head

    var fast = head
    for (index in 1..n) {
        fast = fast?.next
    }
    while (fast != null) {
        fast = fast.next
        pre = pre.next
        slow = slow?.next
    }

    if (slow?.next == null) {
        pre.next = null
    } else {
        slow.`val` = slow.next.`val`
        slow.next = slow.next?.next
    }

    return dump.next

}



fun removeNthFromEnd2(head: ListNode?, n: Int): ListNode? {
    var dump = ListNode(-1)
    dump.next = head
    var slow = dump
    var fast = head

    for (index in 1..n) {
        fast = fast?.next
    }

    while (fast != null) {
        fast = fast.next
        slow = slow.next
    }

//    if (slow.next.next == null) {
//        slow.next = null
//    } else {
//        slow.next.`val` = slow.next.next.`val`
//        slow.next.next = slow.next.next.next
//    }
    return dump.next
}

//推荐
fun removeNthFromEnd3(head: ListNode?, n: Int): ListNode? {
    var dump = ListNode(-1)
    dump.next = head
    var slow = dump
    var fast = head

    for (index in 1..n) {
        fast = fast?.next
    }

    while (fast != null) {
        fast = fast.next
        slow = slow.next
    }

    slow.next = slow.next.next
    return dump.next
}

var curIndex = -1
fun removeNthFromEnd5(head: ListNode?, n: Int): ListNode? {
    var dump:ListNode = ListNode(-1,head)
    removeNthFromEnd4(head,n)
    return dump.next
}
//递归
fun removeNthFromEnd4(head: ListNode?, n: Int) {
    if (head == null){
        curIndex = 0
        return
    }
    removeNthFromEnd4(head.next,n)
    if (curIndex >= 0){
        if (++curIndex == n+1){
            head.next = head.next.next
        }
    }
}


//栈
fun removeNthFromEnd6(head: ListNode?, n: Int) : ListNode?{
    var stack = LinkedList<ListNode>()
    var dump :ListNode? = ListNode(-1,head)
    var cur = dump
    while (cur != null){
        stack.push(cur)
        cur = cur.next
    }
    for (i in 1..n){
        stack.pop()
    }
    val pop = stack.pop()
    pop.next = pop.next.next
    return dump?.next
}

fun main() {
//    removeNthFromEnd(ListNode(1, ListNode(2,ListNode(3, ListNode(4,ListNode(5))))), 2)
    removeNthFromEnd(ListNode(1), 1)
}