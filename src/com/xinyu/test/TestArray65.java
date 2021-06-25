package com.xinyu.test;

public class TestArray65 {

    /**
     * 如何判断两个单链表是否相交，找出第一个相交的节点
     *
     * input: 1 -> 2 -> 3 -> 5 -> 7
     *           4 -> 8 -> 6 -> 9 -> 5 -> 7
     * @param args
     */

        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //int a = in.nextInt();
            //System.out.println(a);
            ListNode one = new ListNode(1);
            one.next = new ListNode(2);
            one.next.next = new ListNode(3);
            one.next.next.next = new ListNode(4);
            one.next.next.next.next = new ListNode(5);


            ListNode another = new ListNode(3);
            another.next = new ListNode(4);
            another.next.next = new ListNode(5);

            System.out.println(getFirst(one,another));


        }

        public static int getFirst(ListNode one , ListNode two){
            ListNode newOne = reverse(one);
            ListNode newTwo = reverse(two);
            int result = -1;

            while(newOne != null && newTwo !=null && newOne.mValue == newTwo.mValue){
                result = newOne.mValue;
                newOne = newOne.next;
                newTwo = newTwo.next;
            }

            return result;


        }

        public static ListNode reverse(ListNode node){
            ListNode cur,next,pre=null;
            while(node != null ){
                cur = node.next;
                node.next = pre;

                if (cur == null) {
                    return node;
                }
                next = cur.next;

                cur.next = node;
                pre = cur;

                node = next;
            }
            return pre;
        }



        static class ListNode {
            public ListNode next;
            public int mValue;

            public ListNode(int value ){
                mValue = value;
            }
        }

}
