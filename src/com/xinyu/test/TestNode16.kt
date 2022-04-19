package com.xinyu.test

/**
 * @see <a href = "https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">aa</a>
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 剑指 Offer 22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。



示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
{@link}
 */
var index = -1
fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
    if (head == null || head.next == null) {
        index = 1
        return head
    }

    val kthFromEnd = getKthFromEnd(head.next, k)

    if (index > 0) {
        index++
    }

    if (k == index) {
        return head
    }
    return kthFromEnd
}

//双指针；


fun getKthFromEnd2(head: ListNode?, k: Int): ListNode? {
    var slow: ListNode? = head
    var fast: ListNode? = head

    for (i in 1..k) {
        fast = fast?.next
    }
    while (fast != null){
        fast = fast.next
        slow = slow?.next
    }
    return slow
}

fun main() {
    for (i in 0..2){
        println(i)
    }
}