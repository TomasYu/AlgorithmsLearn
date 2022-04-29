package com.xinyu.test

class TestNode32 {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

     

    示例 1：


    输入：head = [1,2,3,4]
    输出：[2,1,4,3]
    示例 2：

    输入：head = []
    输出：[]
    示例 3：

    输入：head = [1]
    输出：[1]


    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun swapPairs(head: ListNode?): ListNode? {

        var dumpHead = ListNode(-1,head)
        var preHead  = dumpHead
        var cur = head
        var temp: ListNode?
        while (cur?.next != null){
            preHead.next = cur.next
            temp = cur.next.next
            cur.next.next = cur
            cur.next = temp
            preHead = cur
            cur = cur.next
        }
        return dumpHead.next
    }


}
class TestNode321{

    fun swapPairs(head: ListNode?): ListNode? {
       return reverseNode(head,head?.next)
    }

    private fun reverseNode(node1: ListNode?, node2: ListNode?): ListNode?{
        if (node1 == null || node2 == null) {
            return node1 ?: node2
        }
        val listNode = reverseNode(node1?.next?.next, node2?.next?.next)
        node1.next.next = node1
        node1.next = listNode
        return node2
    }
}