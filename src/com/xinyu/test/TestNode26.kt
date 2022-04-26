package com.xinyu.test

class TestNode26 {


    /**
     * 1171. 从链表中删去总和值为零的连续节点
    给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。

    删除完毕后，请你返回最终结果链表的头节点。



    你可以返回任何满足题目要求的答案。

    （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）

    示例 1：

    输入：head = [1,2,-3,3,1]
    输出：[3,1]
    提示：答案 [1,2,1] 也是正确的。
    示例 2：

    输入：head = [1,2,3,-3,4]
    输出：[1,2,4]
    示例 3：

    输入：head = [1,2,3,-3,-2]
    输出：[1]


    提示：

    给你的链表中可能有 1 到 1000 个节点。
    对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
    https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
     */


    //消消乐一样啊
    //    https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
    //https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/solution/qian-zhui-he-dan-lian-biao-de-qian-zhui-kwr05/
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val map = mutableMapOf<Int, ListNode>()
        map[0] = ListNode(0,head)
        var cur = head
        var curValue = 0
        while (cur != null) {
            curValue += cur.`val`
            if (map[curValue] != null) {
                var listNode = map[curValue]?.next
                var toRemove = curValue
                while (listNode != null && listNode != cur) {
                    toRemove += listNode.`val`
                    map.remove(toRemove)
                    listNode = listNode.next
                }
                map[curValue]?.next = cur.next
            } else {
                map[curValue] = cur
            }
            cur = cur.next
        }
        return map[0]?.next
    }

    fun removeZeroSumSublists2(head: ListNode?): ListNode? {
        val map = mutableMapOf<Int, ListNode>()
        var dump = ListNode(0,head)
        var cur : ListNode? = dump
        var curValue = 0
        while (cur != null) {
            curValue += cur.`val`
            map[curValue] = cur
            cur = cur.next
        }
        cur = dump
        curValue = 0
        while (cur != null){
            curValue += cur.`val`
            if (map[curValue] != cur){
                cur.next = map[curValue]?.next
            }
            cur = cur.next
        }
        return dump.next
    }

}

fun main() {
    println(TestNode26().removeZeroSumSublists(ListNode(1, ListNode(2, ListNode(3, ListNode(-3, ListNode(3)))))))
//    println(TestNode26().removeZeroSumSublists(ListNode(1, ListNode(2, ListNode(-3, ListNode(3, ListNode(1)))))))
//    println(TestNode26().removeZeroSumSublists(ListNode(1, ListNode(2, ListNode(3, ListNode(-3, ListNode(-2)))))))
//    println(TestNode26().removeZeroSumSublists(ListNode(1, ListNode(-1))))
}
