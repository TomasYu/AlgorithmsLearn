package com.xinyu.test

/**
 * {@link <a href="https://leetcode-cn.com/problems/sum-lists-lcci/"></a> }
 *
 *
 * 面试题 02.05. 链表求和
给定两个用链表表示的整数，每个节点包含一个数位。
这些数位是反向存放的，也就是个位排在链表首部。

编写函数对这两个整数求和，并用链表形式返回结果。



示例：

输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
输出：2 -> 1 -> 9，即912
进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?

示例：

输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
输出：9 -> 1 -> 2，即912
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var result = ListNode(-1)
    var cur = result
    var need = false
    var i: Int
    var p1 = l1
    var p2 = l2
    while (p1 != null || p2 != null || need){
        i = 0
        i += p1?.`val`?:0
        i += p2?.`val`?:0
        i += if (need) 1 else 0
        need = false
        if (i >= 10){
            need = true
            i -= 10
        }
        cur.next = ListNode(i)
        cur = cur.next
        p1 = p1?.next
        p2 = p2?.next
    }
    return result.next
}