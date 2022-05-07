package com.xinyu.test

class TestNode35 {
    /**
     * 143. 重排链表
    给定一个单链表 L 的头节点 head ，单链表 L 表示为：

    L0 → L1 → … → Ln - 1 → Ln
    请将其重新排列后变为：

    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



    示例 1：



    输入：head = [1,2,3,4]
    输出：[1,4,2,3]
    示例 2：



    输入：head = [1,2,3,4,5]
    输出：[1,5,2,4,3]


    提示：

    链表的长度范围为 [1, 5 * 104]
    1 <= node.val <= 1000
     */
    fun reorderList(head: ListNode?): Unit {
        if (head?.next?.next == null) {
            return
        }

        var fast = head
        var slow = head
        while (fast?.next != null){
            fast = fast.next.next
            slow = slow?.next
        }
        var head1 = head
        var head2 = slow?.next
        slow?.next = null

        head2 = reverse(head2)

        while (head2 != null){
            val temp = head1?.next
            val temp2 = head2.next
            head1?.next = head2
            head1?.next?.next = temp
            head1 = temp
            head2 = temp2
        }

    }

    fun reverse(node: ListNode?):ListNode?{
        if (node?.next == null){
            return node
        }
        val reverse = reverse(node.next)
        node.next.next = node
        node.next = null
        return reverse
    }

}

class TestNode351{
    fun reorderList(head: ListNode?) {
        reverse(head,head)
    }

    fun reverse(head: ListNode?, tail: ListNode?) : ListNode?{
        if (tail == null) {
            return head
        }
        var reverse = reverse(head,tail.next) ?: return null

        if(reverse.next == tail || reverse == tail){
            tail.next = null
            return null
        }
        tail.next = reverse.next
        reverse.next = tail
        reverse = tail.next
        return reverse
    }
}

fun main() {
    val sortList = TestNode351().reorderList(ListNode(1, ListNode(2, ListNode(3, ListNode(4/*, ListNode(5)*/)))))
    sortList
}