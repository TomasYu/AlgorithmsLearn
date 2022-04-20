package com.xinyu.test

import kotlin.math.min

/**
 * 23. 合并K个升序链表
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

https://leetcode-cn.com/problems/merge-k-sorted-lists/

示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
1->4->5,
1->3->4,
2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]


提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
 */

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var minIndex = 0
    var minNode:ListNode? = null
    var dump = ListNode(-1)
    var cur: ListNode = dump
    while (true){
        for ((index, node) in lists.withIndex()) {
            if (minNode == null) {
                minNode = node
                minIndex = index
            }else{
                //
                if (node != null) {
                    if (minNode.`val` > node.`val`){
                        minNode = node
                        minIndex =index
                    }
                }
            }
        }
        if (minNode == null) {
            break
        }else{
            cur.next = minNode
            cur = cur.next
            lists.set(minIndex,lists.get(minIndex)?.next)
        }
        minNode = null
        minIndex = -1
    }
    return dump.next
}


fun mergeTwoLists3(l1: ListNode?, l2: ListNode?): ListNode? {
    return if (l1 == null){
        l2
    }else if (l2 == null){
        l1
    }else if (l1.`val` > l2.`val`){
        l2.next = mergeTwoLists3(l1,l2.next)
        l2
    }else{
        l1.next = mergeTwoLists3(l1.next,l2)
        l1
    }
}
fun mergeKLists2(lists: Array<ListNode?>): ListNode? {
    var result :ListNode? = null
    for (list in lists) {
        result = mergeTwoLists3(result,list)
    }
    return result
}

//分治


//：使用优先队列合并