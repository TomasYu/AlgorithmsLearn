package com.xinyu.test

class TestNode31 {
    /**
     * 86. 分隔链表
    给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

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
     */
    //https://leetcode-cn.com/problems/partition-list/

    fun partition(head: ListNode?, x: Int): ListNode? {
        val small = ListNode(-1)
        val large = ListNode(-1)
        var cur = head
        var smallH = small
        var largeH = large
        while (cur != null){
            if (cur.`val` >= x){
                largeH.next = cur
                largeH = largeH.next
            }else{
                smallH.next = cur
                smallH = smallH.next
            }
            cur = cur.next
        }
        smallH.next = large.next
        largeH.next = null
        return small.next
    }
}