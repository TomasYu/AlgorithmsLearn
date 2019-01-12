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
//        int [] testArray = new int[]{4,4,1,1,1,0,0,4,4,0};
        int [] testArray = new int[]{-50,-49,-49,-48,-47,-45,-43,-41,-41,-41,-40,-40,-39,-39,-38,-37,-37,-36,-36,-35,-35,-33,-33,-32,-31,-31,-30,-30,-29,-28,-25,-24,-21,-19,-18,-18,-14,-13,-10,-10,-9,-9,-9,-6,-6,-5,-1,1,7,10,10,11,13,14,14,15,20,21,21,22,23,25,26,27,30,30,31,32,33,35,36,38,40,40,41,41,42,44,46,46,46,46,46,47,48,0};
        int [] testArray2 = new int[]{33};
//        moveZeroes(testArray);
//        int i = removeElement(testArray, 2);
//        int i = removeDuplicates2(testArray);
        long l = System.nanoTime();
        merge(testArray,testArray.length-1,testArray2,testArray2.length);
        System.out.println("耗时："+(System.nanoTime() - l)+"纳秒");
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

    /**
     *   删除排序数组中的重复项
     给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

     示例 1:

     给定数组 nums = [1,1,2],

     函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

     你不需要考虑数组中超出新长度后面的元素。
     示例 2:

     给定 nums = [0,0,1,1,1,2,2,3,3,4],

     函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

     你不需要考虑数组中超出新长度后面的元素。
     */

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int temp = 0, j = length - 1;
        /**
         * 整体思路是冒泡排序相同的
         * 第一层循环，循环每一个数字i，
         * 第二层循环，从当前数字i 往后循环每一个数字j，
         * 如果发现i和j相等了，那么把j，用第三层循环，把j循环挪动到末尾，
         * 同时，数组的长度减一
         */
        for (int i = 0; i <= j; i++) {//遍历每一个数
            for (int k = i + 1; k <= j; ) {
                if (nums[i] == nums[k]) {
                    int m = k + 1;
                    for (int q = k; m <= j; m++) {
                        if (nums[q] != nums[m]) {
                            temp = nums[q];
                            nums[q] = nums[m];
                            nums[m] = temp;
                            q = m;
                        }
                    }
                    j--;
                } else {
                    k++;
                }
            }
        }
        return ++j;

        /**
         * 下面是网上最快的解答，但是有问题，
         * 有的测试案例，返回的结果是不正确的。
         * 比如，{0,0,1,1,2,2,0}
         */
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return 1;
//        int length = 1;
//        int currentPos = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[currentPos] != nums[i]) {
//                length++;
//                nums[++currentPos] = nums[i];
//            }
//        }
//        return length;
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

     示例 1:

     给定 nums = [1,1,1,2,2,3],

     函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

     你不需要考虑数组中超出新长度后面的元素。
     示例 2:

     给定 nums = [0,0,1,1,1,1,2,3,3],

     函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。

     你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates2(int[] nums) {
        long l = System.nanoTime();
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int temp = 0, j = length - 1;
        /**
         * 整体思路是冒泡排序相同的
         * 第一层循环，循环每一个数字i，
         * 第二层循环，从当前数字i 往后循环每一个数字j，
         * 如果发现i和j相等了，那么把j，用第三层循环，把j循环挪动到末尾，
         * 同时，数组的长度减一
         */
        for (int i = 0; i <= j; i++) {//遍历每一个数
            for (int k = i + 1,iCount =0; k <= j; ) {
                if (nums[i] == nums[k]) {
                    iCount ++;
                }
                if (nums[i] == nums[k] && iCount >=2) {
                    int m = k + 1;
                    for (int q = k; m <= j; m++) {
                        if (nums[q] != nums[m]) {
                            temp = nums[q];
                            nums[q] = nums[m];
                            nums[m] = temp;
                            q = m;
                        }
                    }
                    j--;
                } else {
                    k++;
                }
            }
        }
        System.out.println("耗时："+(System.nanoTime() - l)+"纳秒");
        return ++j;

        /**
         * 下面是网上最快的解答，但是有问题，
         * 有的测试案例，返回的结果是不正确的。
         *         int [] testArray = new int[]{4,4,1,1,1,0,0,4,4,0};
         */
//       int i = 0;
//        for (int num : nums) {
//            if (i < 2 || num > nums[i - 2]) {
//                nums[i++] = num;
//            }
//        }
//        return i;


        /**
         * 以下为网上解答
         *         int [] testArray = new int[]{4,4,1,1,1,0,0,4,4,0};
            这个测试用例通不过
         */
//        if(nums == null || nums.length == 0 ){
//            return 0;
//        }
//        if(nums.length ==1 ){
//            return 1;
//        }
//        int k =0;
//        for(int i=0; i<nums.length; i++){
//
//            if(k<2 || nums[i]!=nums[k-2] ){
//                nums[k++] = nums[i];
//            }
//        }
//        return k ;
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums ==null) {
            return 0;
        }
        if (k <1) {
            return -1;
        }
        int len = nums.length;
        int temp;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
            if (i == k) {
                break;
            }
        }
                return nums[k -1];
//
//        int left=0,right=nums.length-1;
//        while(left<right){
//            int pivot = partition(nums, left,right);
//            if(pivot ==k-1) {
//                return nums[pivot];
//            } else if(pivot>k-1){
//                right=pivot-1;
//            } else {
//                left=pivot+1;
//            }
//        }
//        return nums[left];
    }

    private static int partition(int[] nums,int left,int right) {
        //先获取三个数的中位数
        int pivot = median3(nums,left,right);
        //int pivot = nums[left];

        int start=left,end=right-1;
        while(start<end) {
            //从pivot左边找起，停在第一个比pivot小的地方，等待交换
            while(nums[++start]>pivot) {}
            //从pivot右边朝气，停在第一个比pivot大的地方，等待交换
            while(nums[--end]<pivot) {}
            if(start<end) {
                swap(nums,start,end);
            }
        }
        //此时，交换start与pivot
        swap(nums,start, right-1);
        return start;
    }

    private static int median3(int[] nums,int left, int right){
        int median=(left+right)/2;
        if(nums[left]<nums[median]) {
            swap(nums, left, median);
        }
        if(nums[left]<nums[right]) {
            swap(nums,left, right);
        }
        if(nums[median]<nums[right]) {
            swap(nums, median, right);
        }
        swap(nums, median, right-1);
        return nums[right-1];

    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    /**
     * 合并两个有序数组
     给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

     说明:

     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     示例:

     输入:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3

     输出: [1,2,2,3,5,6]
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums1.length < m+n) {
            return;
        }
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        if (m ==0) {
            for (int i : nums2) {
                nums1[m++] = i;
            }
            return;
        }

        // 找到第二个数组应该插入的起始位置  startInset 这个位置开始往后插入数组2的数据。包好startInset 这个位置
        int startInsert = 0;
        int nums2Min = nums2[0];
        while (nums2Min >= nums1[startInsert] && startInsert <m){
            startInsert++;
        }
        // 找到第二个数组应该结束插入的位置   这个位置之后的数组1里面的数据  会被直接挪到最后面  不包含该位置
        int endInsert = m>=1 ? m -1 : 0;
        int nums2Max = nums2[n-1];
        if (nums2Max > nums1[endInsert]) {
//            endInsert = m;
        }else {
            while (endInsert >=0 && nums2Max <= nums1[endInsert] ){
                    endInsert--;
            }
        }
        //需要处理有些时候  startInsert 比 endInsert 还要大的问题  该场景是1,2,3,4,5,0  插入数字3 就会出现
        if (endInsert <=startInsert) {
            endInsert =startInsert;
        }

        /**
         * 将数组1里面比数组2大的部分  挪到最后
         */
        for (int i = m-1; i > endInsert; i--) {
            nums1[i+n] = nums1[i];
            nums1[i] = 0;
        }

        /**
         * 从起始插入位置startInsert 到插入完数组1中最大的数的索引位置之间
         * 从后往前，插入n1 n2 中比较大的数字
         */
        for (int j =m + n  -(m > endInsert ? (m- endInsert -1) : 0) -1; j>=startInsert;j--){

            if (endInsert>=0) {
                if (n>=1 && nums2[n-1] > nums1[endInsert]) {
                    nums1[j]=nums2[n-1];
                    n--;
                }else {
                    nums1[j] = nums1[endInsert];
                    endInsert--;
                }
            }else {
                if (n>=1 ) {
                    nums1[j]=nums2[n-1];
                    n--;
                }
            }
        }


//            int n1 = m - 1;
//            int n2 = n - 1;
//            int curr = m + n - 1;
//            while(n1 >= 0 && n2 >=0) {
//                if (nums1[n1] >= nums2[n2]) {
//                    nums1[curr] = nums1[n1];
//                    curr --;
//                    n1 --;
//                } else {
//                    nums1[curr] = nums2[n2];
//                    curr --;
//                    n2 --;
//                }
//            }
//
//            // while(n1 >= 0) {
//            //         nums1[curr] = nums1[n1];
//            //         curr --;
//            //         n1 --;
//            // }
//
//            while(n2 >= 0) {
//                nums1[curr] = nums2[n2];
//                curr --;
//                n2 --;
//            }
    }

}
