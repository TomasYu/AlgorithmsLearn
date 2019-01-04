package com.xinyu.test;

/**
 * Created by zy on 2019/1/4.
 */
public class TestArray
{
    public static void main(String[] args) {
//        int [] testArray = new int[]{1,4,3,33,5,0,2,0,53,0,24,0};
//        int [] testArray = new int[]{1,4,3,33,5,0,2,0,53,0,24,0};
//        int [] testArray = new int[]{0,0,0};
//        int [] testArray = new int[]{1,0};
        int [] testArray = new int[]{0,2,1,223,43223,4234,234,324,3243,243,24};
        moveZeroes(testArray);
        printArray(testArray);
        System.out.println(testArray);

    }


    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

     示例:

     输入: [0,1,0,3,12]
     输出: [1,3,12,0,0]
     说明:

     必须在原数组上操作，不能拷贝额外的数组。
     尽量减少操作次数。
     */
    public static void moveZeroes(int[] nums) {
        //下面是我的解决方法
        int len = nums.length;
        int zeroeSize = 0;
        int temp;

        for (int i = 0; i < len - zeroeSize; i++) {
            if (nums[i] == 0) {
                temp = i +1 ;
                int lianXuZeroe = 1;
                while (temp < len - zeroeSize && nums[temp] == 0){
                    zeroeSize ++;
                    temp ++ ;
                    lianXuZeroe ++;
                }
                for (int j = i; j < len; j++) {
                    if (j + lianXuZeroe < len) {
                        nums[j] = nums[j+lianXuZeroe];
                    }
                }
                zeroeSize ++;
            }
        }

        for (int i = 0; i < zeroeSize; i++) {
            nums[len -1 -i] = 0;
        }

        //下面是别人的解决方法  耗时不到一秒  没有循环移动数组
//        if (nums == null || nums.length < 2) {
//            return;
//        }
//
//        for (int i = 0, j = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j++] = temp;
//            }
//        }




    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("第"+ i +"个元素是："+array[i]);
        }
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void MaoPao(int nums[]) {
        if (nums ==null) {
            return;
        }
        int len = nums.length;
        int temp;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
