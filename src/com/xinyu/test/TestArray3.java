package com.xinyu.test;

/**
 * Created by zy on 2019/3/5.
 */
public class TestArray3 {
    public static void main(String[] args) {
//        1.
//        int[] ints = plusOne(new int[]{9,9});
//        Utils.printArray(ints);

//        2.
        /**
         * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

         你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

         示例:

         给定 nums = [2, 7, 11, 15], target = 9

         因为 nums[0] + nums[1] = 2 + 7 = 9
         所以返回 [0, 1]
         */
        int[] ints = twoSum(new int[]{2047,0, 800001, 800000, 7,2,2048}, 4095);
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


    public static int[] twoSum(int[] nums, int target) {
        //执行用时：63 ms
        int length = nums.length;
        //i j  首位两个数字
        for (int i = 0 ,j = length -1;i < j ;i++,j--){
            if (nums[i] + nums[j] == target) {
                return new int[]{i,j};
            }
                // k 是i 后面的一位
            for (int k = i +1; k < j; k++){
                //  如果满足条件  返回   否则k 移动
                if (nums[i] + nums[k] == target){
                    return new int[]{i,k};
                }else if (nums[j] + nums[k] == target){
                    return new int[]{k,j};
                }
            }
            // 全都不满足条件  ij 移动

        }
        return null;



        /*
        1100 0011 0101 0000 0000  800000  num[i]
		            111 1111 1111   2047  length
		            101 0000 0000   1280   index



        1 1000 0110 1010 0000 0000    target 1600000
			         101 0000 0000  index
        1 1000 0110 0101 0000 0000   target -index
			  111 1111 1111   2047  length


			 101 0000 0000

         */
//        int size = 2048;
//        int[] map = new int[size];
//        int length = 2047;
//        int index;
//        for (int i = 0; i < nums.length; i++) {
//            index = nums[i]&length; //
//
//            if (map[index] != 0) {
//                return new int[] { map[index] - 1, i };
//            } else {
//                map[(target - index)&length ] = i + 1;
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");

    }
}
