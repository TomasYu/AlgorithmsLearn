package com.xinyu.test

class TestNode30 {
    /**
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/
     *
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     

    示例 1：


    输入：head = [1,2,3,4,5], left = 2, right = 4
    输出：[1,4,3,2,5]
    示例 2：

    输入：head = [5], left = 1, right = 1
    输出：[5]
     

    提示：

    链表中节点数目为 n
    1 <= n <= 500
    -500 <= Node.val <= 500
    1 <= left <= right <= n
     

    进阶： 你可以使用一趟扫描完成反转吗？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //https://leetcode-cn.com/problems/reverse-linked-list-ii
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var index = 0
        var dump = ListNode(-1, head)
        var pre = dump
        var next: ListNode
        var cur: ListNode? = dump
        while (cur != null){
            if (index + 1 == left){
                pre = cur
            }

            if (index in left until right){
                next = cur.next
                cur.next = cur.next.next
                next?.next = pre.next
                pre.next = next
            }else{
                cur = cur.next
            }
            index++
        }
        return dump.next
    }
}

fun main() {
    TestNode30().reverseBetween(ListNode(1, ListNode(2, ListNode(3, ListNode(4,ListNode(5))))),2,4)
}