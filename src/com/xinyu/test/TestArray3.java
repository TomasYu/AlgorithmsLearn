package com.xinyu.test;

/**
 * Created by zy on 2019/3/5.
 */
public class TestArray3 {
    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{9,9});
        Utils.printArray(ints);
    }


    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

     最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

     你可以假设除了整数 0 之外，这个整数不会以零开头。

     示例 1:

     输入: [1,2,3]
     输出: [1,2,4]
     解释: 输入数组表示数字 123。
     示例 2:

     输入: [4,3,2,1]
     输出: [4,3,2,2]
     解释: 输入数组表示数字 4321。
     */
    public static int[] plusOne(int[] digits) {
        //第一版
        //last 表示当前加1的位置
//        int last = digits.length-1;
//        // 如果当前加1  大于等于10
//        while (last >=0 && digits[last] +1 >=10){
//            //当前位置的数字为10的余数
//            digits[last] = (digits[last] +1) %10;
//            //需要加1的位置往前走
//            last --;
//        }
//        //如果需要加1的位置是-1 说明当前数组不够用了
//        if (last == -1) {
//            int[] arr = new int[digits.length+1];
//            arr[0] = 1;
//            System.arraycopy(digits,0,arr,1,digits.length-1);
//            return arr;
//        }else {
//            digits[last] +=1;
//        }
//        return digits;


        //第二版
        //last 表示当前加1的位置
        int last = digits.length-1;
        // 如果当前加1  大于等于10
        while (last >=0 && digits[last] ==9){
            //当前位置的数字为10的余数
            digits[last] = 0;
            //需要加1的位置往前走
            last --;
        }
        //如果需要加1的位置是-1 说明当前数组不够用了
        if (last == -1) {
            int[] arr = new int[digits.length+1];
            arr[0] = 1;
            System.arraycopy(digits,0,arr,1,digits.length-1);
            return arr;
        }else {
            digits[last] +=1;
        }
        return digits;

    }
}
