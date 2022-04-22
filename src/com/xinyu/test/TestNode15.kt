package com.xinyu.test

/**
 * 剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：

输入：head = [1,3,2]
输出：[2,3,1]


限制：

0 <= 链表长度 <= 10000
 */
fun reversePrint(head: ListNode?): IntArray {
    var list = mutableListOf<Int>()
    reverse(head,list)
    return list.toIntArray()

}

private fun reverse(head: ListNode?,list:MutableList<Int>){
    if (head == null) {
        return
    }
    reverse(head.next,list)
    list.add(head.`val`)
}



fun reversePrint2(head: ListNode?): IntArray {
    var deque = ArrayDeque<Int>()
    var cur = head
    while (cur != null) {
        deque.addLast(cur.`val`)
        cur = cur.next
    }
    var result =  IntArray(deque.size)
    var i  =  0
    while (!deque.isEmpty()){
        result[i++] = deque.removeLast()
    }
    return result
}


//fun reversePrint2(head: ListNode?): IntArray {
//    var deque = ArrayDeque<Int>()
//    if (head != null) {
//        deque.addLast(head.`val`)
//    }
//    var result =  IntArray(deque.size)
//    var temp : Int?
////    temp = deque.lastOrNull()
//    while ((temp = deque.lastOrNull()) != null){
////        result[1] =
//    }
//    return list.toIntArray()
//
//}