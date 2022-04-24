package com.xinyu.test

import java.util.*

/**
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 * 给定一个长度为 n 的链表 head

对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。

返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。

 

示例 1：



输入：head = [2,1,5]
输出：[5,5,0]
示例 2：



输入：head = [2,7,4,3,5]
输出：[7,0,5,5,0]
 

提示：

链表中节点数为 n
1 <= n <= 104
1 <= Node.val <= 109


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//fun nextLargerNodes(head: ListNode?): IntArray {
//
//    //hasMap 每一个数都和hash里面为空的去比较
//    //输入：
//    //[1,7,5,1,9,2,5,1]
//    //输出：
//    //[0,9,0,0,0,5,0,0]
//    //预期结果：
//    //[7,9,9,9,0,5,0,0]  有重复数字
//    var map = HashMap<Int,Int>()
//    var cur = head
//    while (cur != null){
//        map.entries.forEach {
//            if (it.value == -1) {
//                if (cur!!.`val` > it.key){
//                    map[it.key] = cur!!.`val`
//                }
//            }
//        }
//        map[cur.`val`] = -1
//        cur = cur.next
//    }
//
//    var result = mutableListOf<Int>()
//    cur = head
//    while (cur != null){
//        result.add(if (map[cur.`val`]!! == -1) 0 else map[cur.`val`]!!)
//        cur = cur.next
//    }
//    return result.toIntArray()
//}

//https://leetcode-cn.com/problems/next-greater-node-in-linked-list/solution/5chong-jie-jue-fang-shi-tu-wen-xiang-jie-by-sdwwld/
class TestNode25{
    fun nextLargerNodes(head: ListNode?): IntArray {
        //使用单调栈
        val result = mutableListOf<Int>()
        var stack = LinkedList<Int>()
        var cur = head
        var i = 0
        while (cur != null){
            while (!stack.isEmpty() && cur.`val` > result[stack.peek()]) {
                result[stack.pop()] = cur.`val`
            }
            stack.push(i++)
            result.add(cur.`val`)
            cur = cur.next
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0
        }
        return result.toIntArray()
    }
}