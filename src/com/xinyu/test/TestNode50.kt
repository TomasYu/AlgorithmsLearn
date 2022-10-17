package com.xinyu.test

class TestNode50 {

    /**
     * 1290. 二进制链表转整数
    给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

    请你返回该链表所表示数字的 十进制值 。



    示例 1：



    输入：head = [1,0,1]
    输出：5
    解释：二进制数 (101) 转化为十进制数 (5)
    示例 2：

    输入：head = [0]
    输出：0
    示例 3：

    输入：head = [1]
    输出：1
    示例 4：

    输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
    输出：18880
    示例 5：

    输入：head = [0,0]
    输出：0


    提示：

    链表不为空。
    链表的结点总数不超过 30。
    每个结点的值不是 0 就是 1。
     */

    var result = 0
    var cur = 0
    fun getDecimalValue(head: ListNode?): Int {
        result += if (head?.next == null) {
            head?.`val`?.shl(cur++) ?: 0
        }else{
            getDecimalValue(head.next)
            head.`val`.shl(cur++)
        }
        return result
    }


    fun getDecimalValue2(head: ListNode?): Int {
        var temp = 0
        var tHead = head
        while (tHead != null){
            temp = temp * 2 + tHead.`val`
            tHead = tHead.next
        }
        return temp
    }
}

fun main() {
    println(TestNode50().getDecimalValue2(ListNode(1, ListNode(0, ListNode(1)))))
}
