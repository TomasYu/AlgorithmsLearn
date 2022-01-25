package com.xinyu.test;

public class TestNode1 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     *
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     *  
     *
     * 提示：
     *
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null,tail = null;
        while (list1 != null && list2 != null){
            if (head == null) {
                if (list1.val <= list2.val){
                    head = new ListNode(list1.val);
                    list1 = list1.next;
                }else {
                    head = new ListNode(list2.val);
                    list2 = list2.next;
                }
                tail = head;
            }else {
                if (list1.val <= list2.val){
                    tail.next = new ListNode(list1.val);
                    list1 = list1.next;
                }else {
                    tail.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                tail = tail.next;

            }

        }
        if (list1 != null) {
            if (head == null){
                head = list1;
                tail = head;

            }else {
                while (list1 != null){
                    tail.next = list1;
                    list1 = list1.next;
                    tail = tail.next;

                }
            }
        }

        if (list2 != null) {
            if (head == null){
                head = list2;
                tail = head;

            }else {
                while (list2 != null){
                    tail.next = list2;
                    list2 = list2.next;
                    tail = tail.next;
                }
            }
        }
        return head;

    }

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }
    }
}
