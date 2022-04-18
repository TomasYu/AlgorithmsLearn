package com.xinyu.test

fun main() {
    println(isPalindrome(ListNode(1, ListNode(0, ListNode(1)))))
}


/**
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/solution/di-gui-zhan-deng-3chong-jie-jue-fang-shi-zui-hao-2/
 */

var realHead: ListNode? = null
fun isPalindrome(head: ListNode?): Boolean {
    realHead = head
    return check(head)
}

fun check(head: ListNode?): Boolean {
    if (head == null) {
        return true
    }
    if (check(head.next) && (head.`val` == realHead?.`val`)) {
        realHead = realHead?.next
        return true
    }
    return false
}