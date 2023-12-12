package com.xinyu.test

class TestNode55 {
    //https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
    /**
    2095. 删除链表的中间节点
    提示
    中等
    64
    相关企业
    给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。

    长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。

    对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。


    示例 1：



    输入：head = [1,3,4,7,1,2,6]
    输出：[1,3,4,1,2,6]
    解释：
    上图表示给出的链表。节点的下标分别标注在每个节点的下方。
    由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
    返回结果为移除节点后的新链表。
    示例 2：



    输入：head = [1,2,3,4]
    输出：[1,2,4]
    解释：
    上图表示给出的链表。
    对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
    示例 3：



    输入：head = [2,1]
    输出：[2]
    解释：
    上图表示给出的链表。
    对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
    值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。


    提示：

    链表中节点的数目在范围 [1, 105] 内
    1 <= Node.val <= 105

     快满指针是单链表的标准解决思路
     */
    var length = -1
    var result = 0
    fun deleteMiddle(head: ListNode?): ListNode? {
        //长度怎么获取？
        //怎么删除？
        //这还是单链表
        //单链表怎么返回呢？？
        //简单一点就是来两遍 第一遍数有多少个 第二遍开始删除 递归
        var listNode = ListNode(-1,head)
        dfs(listNode)
        return listNode.next
    }
    fun dfs(head: ListNode?){
        if (head == null){
            //得到长度
            result =  length - length /2
            return
        }
        length++
        dfs(head.next)
        result--
        if (result == -1){
            //删除
            head.next = head.next.next
        }
    }
}