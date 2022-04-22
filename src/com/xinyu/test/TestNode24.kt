package com.xinyu.test

import java.util.*

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 

示例1：



输入：l1 = [7,2,4,3], l2 = [5,6,4]
输出：[7,8,0,7]
示例2：

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[8,0,7]
示例3：

输入：l1 = [0], l2 = [0]
输出：[0]
 

提示：

链表的长度范围为 [1, 100]
0 <= node.val <= 9
输入数据保证链表代表的数字无前导 0


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution{
    //递归理论上也是可以  但是没有写出来
    var result:ListNode = ListNode(-1)
    var cur= result
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        reverse(l1?.next,l2?.next)
        return result.next
    }

    fun reverse(l1: ListNode?, l2: ListNode?){

        if (l1 == null && l2 == null) {
            return
        }


        reverse(l1?.next,l2?.next)

        l1?.`val`
        l2?.`val`

    }



}
private class T_addTwoNumbers{
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result = ListNode(-1)
        var cur = result
        var l1Stack = LinkedList<Int>()
        var l2Stack = LinkedList<Int>()
        var resultStack = LinkedList<Int>()
        var p1 = l1
        var p2 = l2

        while (p1 != null){
            l1Stack.push(p1.`val`)
            p1 = p1.next
        }

        while (p2 != null){
            l2Stack.push(p2.`val`)
            p2 = p2.next
        }
        var needAdd = false
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || needAdd){
            var temp =  0
            temp += if (!l1Stack.isEmpty()) l1Stack.pop() else 0
            temp += if (!l2Stack.isEmpty()) l2Stack.pop() else 0
            temp += if (needAdd) 1 else 0
            needAdd = false

            if (temp >= 10){
                temp -= 10
                needAdd = true
            }
            resultStack.push(temp)
        }

        while (!resultStack.isEmpty()){
            cur.next = ListNode(resultStack.pop())
            cur = cur.next
        }

        return result.next
    }

}
