package com.xinyu.test

class TestNode48 {
    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

    你应当 保留 两个分区中每个节点的初始相对位置。

     

    示例 1：


    输入：head = [1,4,3,2,5,2], x = 3
    输出：[1,2,2,4,3,5]
    示例 2：

    输入：head = [2,1], x = 2
    输出：[1,2]
     

    提示：

    链表中节点的数目在范围 [0, 200] 内
    -100 <= Node.val <= 100
    -200 <= x <= 200


    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/partition-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun partition(head: ListNode?, x: Int): ListNode? {
        var dumpS = ListNode(-1)
        var dumpL = ListNode(-1)
        var curS = dumpS
        var curL = dumpL
        var cur = head
        while (cur != null){
            if (cur.`val` < x){
                curS.next = cur
                curS = curS.next
            }else{
                curL.next = cur
                curL = curL.next

            }
            cur = cur.next

        }
        curS.next = null
        curL.next = null
        curS.next = dumpL.next
        return dumpS.next
    }
}

fun main() {
    println(TestNode48().partition(ListNode(1, ListNode(4, ListNode(3, ListNode(2, ListNode(5, ListNode(2)))))), 3))
}