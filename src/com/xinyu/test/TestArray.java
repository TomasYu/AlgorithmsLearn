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
        int [] testArray = new int[]{0,1,2,2,3,0,4,2};
//        moveZeroes(testArray);
        int i = removeElement(testArray, 2);
        System.out.println("i :" + i);
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

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

     元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

     示例 1:

     给定 nums = [3,2,2,3], val = 3,

     函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

     你不需要考虑数组中超出新长度后面的元素。
     示例 2:

     给定 nums = [0,1,2,2,3,0,4,2], val = 2,

     函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

     注意这五个元素可为任意顺序。

     你不需要考虑数组中超出新长度后面的元素。
     说明:

     为什么返回数值是整数，但输出的答案是数组呢?

     请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {

        //我的解决方法  9ms
        if (nums ==null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int temp = 0;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return j;


        //别人的方法： 5ms
//        if(nums.length==0)
//            return 0;
//        int i,j;
//        for(i=0,j=nums.length-1;i<=j;) {
//            if(nums[j]==val){
//                j--;
//            } else {
//                if(nums[i]!=val)
//                    i++;
//                else {
//                    nums[i]=nums[j];
//                    j--;
//                }
//            }
//        }
//        j++;
//        return j;

    }




}
