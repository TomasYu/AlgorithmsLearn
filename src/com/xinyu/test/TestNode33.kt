package com.xinyu.test


class TestNode33 {
    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

     

    示例 1：


    输入：head = [4,2,1,3]
    输出：[1,2,3,4]
    示例 2：


    输入：head = [-1,5,3,4,0]
    输出：[-1,0,3,4,5]
    示例 3：

    输入：head = []
    输出：[]
     

    提示：

    链表中节点的数目在范围 [0, 5 * 104] 内
    -105 <= Node.val <= 105

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/sort-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null){
            return head
        }
        var slow = head
        var fast = head.next
        while (fast?.next != null){
            slow = slow?.next
            fast = fast.next.next
        }

        var temp = slow?.next
        slow?.next = null

        var node1 = sortList(head)
        var node2 = sortList(temp)

        var dump = ListNode(-1)
        var cur = dump
        while (node1 != null && node2 != null){
            if (node1.`val` < node2.`val`){
                cur.next =  node1
                node1 = node1.next
            }else{
                cur.next = node2
                node2 = node2.next
            }
            cur = cur.next
        }
        cur.next = node1 ?: node2
        return dump.next
    }
}

fun main() {
    val sortList = TestNode33().sortList(ListNode(4, ListNode(2, ListNode(1, ListNode(3)))))
    sortList
}