package com.xinyu.test

/**
 * 剑指 Offer II 024. 反转链表
给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。



示例 1：


输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：


输入：head = [1,2]
输出：[2,1]
示例 3：

输入：head = []
输出：[]


提示：

链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000


进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？


 */
var newHead:ListNode? = null
fun reverseList(head: ListNode?): ListNode? {
    reverse(head)
    return newHead
}
fun reverse(head: ListNode?){

    if (head?.next == null) {
        newHead = head
        return
    }
    reverse(head.next)
    head.next.next = head
    head.next = null
}
class Te2{
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val newHead = reverseList(head.next)
        head.next.next = head
        head.next = null
        return newHead
    }
}
