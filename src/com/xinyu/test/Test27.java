package com.xinyu.test;

public class Test27 {
    /**
     * 数组实现栈，实现push，pop，size方法
     */

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("----");
        System.out.println("size " + stack.size());

        System.out.println("----");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());



    }

    public static class Stack{
        private int[] arr;
        private int count;

        public Stack(){
            arr = new int[2];
        }
        public void push(int num){
            //容量需要扩容
            if(count >= arr.length){
                int[] arrNew = new int[count*2];
//                System.arrayCopy(arrNew,arr,0,count,0,count);
                System.arraycopy(arr,0,arrNew,0,count);
                arr = arrNew;
                //
                arr[count++] = num;
            }else{
                arr[count++] = num;
            }
        }

        public int pop(){
            //这里应该是先--
//            return arr[count--];   //--count
            if (count <= 0) {
                return -1;
            }
            return arr[--count];   //--count
        }

        public int size(){
            return count;
        }

    }

}
