package com.xinyu.test

/**
 * @see <a href = "https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">aa</a>
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 剑指 Offer 22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。



示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
{@link}
 */
var index = -1
fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
    if (head == null || head.next == null) {
        index = 1
        return head
    }

    val kthFromEnd = getKthFromEnd(head.next, k)

    if (index > 0) {
        index++
    }

    if (k == index) {
        return head
    }
    return kthFromEnd
}

//双指针；


fun getKthFromEnd2(head: ListNode?, k: Int): ListNode? {
    var slow: ListNode? = head
    var fast: ListNode? = head

    for (i in 1..k) {
        fast = fast?.next
    }
    while (fast != null) {
        fast = fast.next
        slow = slow?.next
    }
    return slow
}

fun main() {
    for (i in 0..2) {
        println(i)
    }
    val convertBiNode = convertBiNode(TreeNode(4,
            TreeNode(2, TreeNode(1, TreeNode(0, null, null), null), TreeNode(3, null, null)),
            TreeNode(5, null, TreeNode(6, null, null))))
    convertBiNode?.`val`
}


/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。

返回转换后的单向链表的头节点。

注意：本题相对原题稍作改动

 

示例：

输入： [4,2,5,1,3,null,6,0]
输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
提示：

节点数量不会超过 100000。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binode-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun convertBiNode(root: TreeNode?): TreeNode? {
    convertBiNode2(root)
    return head
}

var head: TreeNode? = null
var pre: TreeNode? = null
fun convertBiNode2(root: TreeNode?) {
    if (root == null) {
        return
    }
    val left = root.left
    val right = root.right
    convertBiNode2(left)
    if (head == null) {
        head = root
        pre = head
    } else {
        pre?.right = root
        pre = root
    }
    root.left = null
    convertBiNode2(right)
}

