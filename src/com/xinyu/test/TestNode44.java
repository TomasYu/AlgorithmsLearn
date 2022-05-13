package com.xinyu.test;

public class TestNode44 {

    public ListNode detectCycle(ListNode head) {
        // 判断是否有环
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                //计算起点到环的距离
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
