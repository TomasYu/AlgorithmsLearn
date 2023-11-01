package com.xinyu.test;

import java.util.Arrays;

/**
 * Created by zy on 2019/1/4.
 */
public class TestArray
{
    public static void main(String[] args) {
        int [] testArray = new int[]{1,4,3,33,5,0,2,0,53,0,24,0};
//        int [] testArray = new int[]{-50,-49,-49,-48,-47,-45,-43,-41,-41,-41,-40,-40,-39,-39,-38,-37,-37,-36,-36,-35,-35,-33,-33,-32,-31,-31,-30,-30,-29,-28,-25,-24,-21,-19,-18,-18,-14,-13,-10,-10,-9,-9,-9,-6,-6,-5,-1,1,7,10,10,11,13,14,14,15,20,21,21,22,23,25,26,27,30,30,31,32,33,35,36,38,40,40,41,41,42,44,46,46,46,46,46,47,48,0};
//        int [] testArray2 = new int[]{33};
        moveZeroes(testArray);
//        int i = removeElement(testArray, 2);
//        int i = removeDuplicates2(testArray);
        long l = System.nanoTime();
//        merge(testArray,testArray.length-1,testArray2,testArray2.length);
        /**
         * test sum
         */
//        int [] testArray = new int[]{-1,0};
//        testArray = twoSum(testArray,-1);


        boolean palindrome = isPalindrome("0P");
        System.out.println("isPalindrome:" + palindrome);


        /**
         *  test 元音字母
         */
        reverseVowels("hello");


        /**
         * test [1,2,4,3]
         */

        int maxArea = maxArea(new int[]{1, 2, 4, 3});
        System.out.println("maxArea: "+maxArea);


        /**
         * test minSubArrayLen
         */
        int minSubArrayLen = minSubArrayLen(5, new int[]{1,1,1,3,2,1,1});
        System.out.println("minSubArrayLen : " + minSubArrayLen);


        System.out.println("耗时："+(System.nanoTime() - l)+"纳秒");
        printArray(testArray);
        System.out.println(testArray);

    }


    //https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
    /**
     *
     * 移动零
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
//        int len = nums.length;
//        int zeroeSize = 0;
//        int temp;
//
//        for (int i = 0; i < len - zeroeSize; i++) {
//            if (nums[i] == 0) {
//                temp = i +1 ;
//                int lianXuZeroe = 1;
//                while (temp < len - zeroeSize && nums[temp] == 0){
//                    zeroeSize ++;
//                    temp ++ ;
//                    lianXuZeroe ++;
//                }
//                for (int j = i; j < len; j++) {
//                    if (j + lianXuZeroe < len) {
//                        nums[j] = nums[j+lianXuZeroe];
//                    }
//                }
//                zeroeSize ++;
//            }
//        }
//
//        for (int i = 0; i < zeroeSize; i++) {
//            nums[len -1 -i] = 0;
//        }

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

        // 我后来，复盘的时候，模拟最优解决方法的思路   发现自己还有很多需要学习的
        // 脑子不够用 就画图 一步一步的画图  就知道做了这一步， 下一步怎么做
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//        int length = nums.length;
//        int j = -1 ;
//        for (int i = 0; i < length; i++) {
//            if (nums[i] == 0) {
//                if (j == -1) {
//                    j =i;
//                }
//            }else {
//                if (j != -1) {
//                    nums[j] = nums[i];
//                    nums[i] = 0;
//                    j ++ ;
//                }
//            }
//        }

        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        int j = 0 ,temp ;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
//                if (j == -1) {
//                    j =i;
//                }
            }else {
//                if (j != -1) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j ++ ;
//                }
            }
        }


    }

    @Deprecated
    public static void printArray(int[] array){
        Utils.printArray(array);
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


    /**
     * 两数之和 II - 输入有序数组
     给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

     函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

     说明:

     返回的下标值（index1 和 index2）不是从零开始的。
     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     示例:

     输入: numbers = [2, 7, 11, 15], target = 9
     输出: [1,2]
     解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */

    public static int[] twoSum(int[] numbers, int target) {
        int[]result = {0,0};
        int length = numbers.length;
        if (length <2) {
            return result;
        }
        int endIndex = length -1;
        int startIndex = 0;
        //找到比target 小的第一个数  需要考虑有负数的情况
//        while (endIndex >=0 && numbers[endIndex] >= target){
//            endIndex--;
//        }
//        // 该数组没有满足条件的
//        if (endIndex == 0) {
//            return result;
//        }

        //从最小的那个数 往前遍历循环  如果当前的这个数 和前面的数都不符合  该数pass
        //遍历的时候，当前的数和在遍历的数 如果比要找的数大 后面直接不用遍历
        //直接遍历下一个数

        //优化点：  1. 一层for 循环就可以  不要想的太复杂  2.遍历的时候，当前的数和在遍历的数 如果比要找的数小 前面的直接不用遍历
        out:for (; endIndex > 0; endIndex--) {
            for (; startIndex <endIndex; startIndex++) {
                int sum = numbers[endIndex] + numbers[startIndex];
                if (sum == target) {
                    break out;
                }else if (sum > target){
                    //结束层循环
//                    i = endIndex;
                    break;
                }

            }
        }
        //最后返回两个索引
        result[0] = ++startIndex;
        result[1] = ++endIndex;
        return result;

        //双索引遍历  只遍历了一遍  代码也易读 易维护
//        int left = 0;
//        int right = numbers.length - 1;
//        while (left < right) {
//            if (numbers[left] + numbers[right] > target) {
//                right--;
//            } else if (numbers[left] + numbers[right] == target){
//                return new int[] {left + 1, right + 1};
//            } else {
//                left++;
//            }
//        }
//
//        return null;


        //网上最快的 通过2分查找   确实 两个数只和  要么是两个一样的中间数  要么是一个比他大的数  一个比他小的数加起来的
        // 因为二分法查找的两个数的合  所以二分法查找的一定在第一个数的右边  所以下面numbers[load - 1] 里面的load - 1 不可能是-1
//        int[] ans = new int[2];
//        int half = target / 2;
//        int load = Arrays.binarySearch(numbers, half) >= 0 ? Arrays.binarySearch(numbers, half)
//                : Arrays.binarySearch(numbers, half) * -1 - 1;
//        if (numbers[load - 1] + numbers[load] == target) {
//            ans[0] = load;
//            ans[1] = load + 1;
//            return ans;
//        }
//        if (numbers[load] + numbers[load + 1] == target) {
//            ans[0] = load + 1;
//            ans[1] = load + 2;
//            return ans;
//        }
//        int start = load - 1;
//        int end = load;
//        while (start >= 0 && end < numbers.length) {
//            if (numbers[start] + numbers[end] > target) {
//                start--;
//            } else if (numbers[start] + numbers[end] < target) {
//                end++;
//            } else {
//                ans[0] = start + 1;
//                ans[1] = end + 1;
//                return ans;
//            }
//        }
//        return null;

    }


    /**
     *  验证回文串
     给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

     说明：本题中，我们将空字符串定义为有效的回文串。

     示例 1:

     输入: "A man, a plan, a canal: Panama"
     输出: true
     示例 2:

     输入: "race a car"
     输出: false
     */
    public static boolean isPalindrome(String s) {
//        第一版本
//        String string = s.replaceAll(" ", "");
//        int length = string.length();
//        if (length == 0 || length == 1) {
//            return true;
//        }
//        for (int i = 0,j =length-1; j > 0 && j>i;) {
//            char headChar = string.charAt(i);
//            if (!Character.isDigit(headChar) &&  !Character.isAlphabetic(headChar)) {
//                i++;
//                continue;
//            }
//
//            char endChar = string.charAt(j);
//            if (!Character.isDigit(endChar) &&  !Character.isAlphabetic(endChar)) {
//                j--;
//                continue;
//            }
//            if (headChar != endChar && (Character.isLowerCase(headChar)? Character.toUpperCase(headChar) : Character.toLowerCase(headChar)) != endChar) {
//                return false;
//            }else {
//                i++;
//                j--;
//            }
//
//        }
//        return true;

//// 第二版本   去掉s.replaceAll(" ", "")  直接减低了20ms
//        int length = s.length();
//        if (length == 0 || length == 1) {
//            return true;
//        }
//        for (int i = 0,j =length-1; j > 0 && j>i;) {
//            char headChar = s.charAt(i);
//            if (!Character.isDigit(headChar) &&  !Character.isAlphabetic(headChar)) {
//                i++;
//                continue;
//            }
//
//            char endChar = s.charAt(j);
//            if (!Character.isDigit(endChar) &&  !Character.isAlphabetic(endChar)) {
//                j--;
//                continue;
//            }
//            if (headChar != endChar && (Character.isLowerCase(headChar)? Character.toUpperCase(headChar) : Character.toLowerCase(headChar)) != endChar) {
//                return false;
//            }else {
//                i++;
//                j--;
//            }
//
//        }
//        return true;



        // 第三版本   去掉s.replaceAll(" ", "")  直接减低了20ms
//        char[] chars = s.toCharArray();
//        int length = chars.length;
//        if (length == 0 || length == 1) {
//            return true;
//        }
//        for (int i = 0,j =length-1; j > 0 && j>i;) {
//            char headChar = chars[i];
//            if (!Character.isDigit(headChar) &&  !Character.isAlphabetic(headChar)) {
//                i++;
//                continue;
//            }
//
//            char endChar = chars[j];
//            if (!Character.isDigit(endChar) &&  !Character.isAlphabetic(endChar)) {
//                j--;
//                continue;
//            }
//            if (headChar != endChar && (Character.isLowerCase(headChar)? Character.toUpperCase(headChar) : Character.toLowerCase(headChar)) != endChar) {
//                return false;
//            }else {
//                i++;
//                j--;
//            }
//
//        }
//        return true;


        //第四版本
        int length = s.length();
        if (length == 0 || length == 1) {
            return true;
        }
        for (int i = 0,j =length-1; j>i;) {
            char headChar = s.charAt(i);
            if (headChar >= 'A' && headChar<= 'Z'){//抓换成小写
                headChar +=32;
            }else if (! ((headChar >= 'a' && headChar<= 'z')  || (headChar >= '0' && headChar<='9'))){
                i++;
                continue;
            }


            char endChar = s.charAt(j);
            if (endChar >= 'A' && endChar<= 'Z'){//抓换成小写
                endChar +=32;
            }else if (! ((endChar >= 'a' && endChar<= 'z')  || (endChar >= '0' && endChar<='9'))){
                j--;
                continue;
            }

            if (headChar != endChar ) {
                return false;
            }else {
                i++;
                j--;
            }

        }
        return true;
    }

    /*
    反转字符串中的元音字母
    编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

    示例 1:

    输入: "hello"
    输出: "holle"
    示例 2:

    输入: "leetcode"
    输出: "leotcede"
    说明:
    元音字母不包含字母"y"。
    a e i o u
    */

    public static String reverseVowels(String s) {
        if (s == null || s.length()==0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        char temp;
        for (int i = 0 , j = length -1 ; j > i ;){
            if (!(chars[i] == 'a' || chars[i] == 'e' ||chars[i] == 'i' ||chars[i] == 'o' ||chars[i] == 'u'||chars[i] == 'A' || chars[i] == 'E' ||chars[i] == 'I' ||chars[i] == 'O' ||chars[i] == 'U')) {
                i++;
                continue;
            }

            if (!(chars[j] == 'a' || chars[j] == 'e' ||chars[j] == 'i' ||chars[j] == 'o' ||chars[j] == 'u'|| chars[j] == 'A' || chars[j] == 'E' ||chars[j] == 'I' ||chars[j] == 'O' ||chars[j] == 'U')) {
                j--;
                continue;
            }
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i ++ ;
            j -- ;
        }

        return String.valueOf(chars);

//        boolean[] flags = new boolean[126];
//        flags['a'] = true;
//        flags['e'] = true;
//        flags['i'] = true;
//        flags['o'] = true;
//        flags['u'] = true;
//        flags['A'] = true;
//        flags['E'] = true;
//        flags['I'] = true;
//        flags['O'] = true;
//        flags['U'] = true;
//        char[] arr = s.toCharArray();
//        int left = 0, right = arr.length - 1;
//        while (left < right) {
//            if (!flags[arr[left]]) {
//                left++;
//                continue;
//            }
//            if (!flags[arr[right]]) {
//                right--;
//                continue;
//            }
//            swap(arr, left, right);
//            left++;
//            right--;
//        }
//        return String.valueOf(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * 盛最多水的容器
     给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

     说明：你不能倾斜容器，且 n 的值至少为 2。

     备注：图片在pic/question_11.jpg
     图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     示例:

     输入: [1,8,6,2,5,4,8,3,7]
     输出: 49
     */

    public static int maxArea(int[] height) {
//        int length = height.length;
//        if (length == 0) {
//            return 0;
//        }else if (length == 1){
//            return height[0];
//        }
//
//        int max = 0;
//        for (int i =0, j =length -1; j > i ;  ){
//            int minHeight = Math.min(height[i], height[j]);
//            max = Math.max(max,minHeight * (j -i));
//            if (height[i] > height[j]) {
//                j--;
//            }else {
//                i++;
//            }
//        }
//        return max;



        int length = height.length;
        if (length == 0) {
            return 0;
        }else if (length == 1){
            return height[0];
        }

        int max = 0;
        for (int i =0, j =length -1; j > i ;  ){
            int start = height[i];
            int end = height[j];
            int minHeight = Math.min(start, end);
            max = Math.max(max,minHeight * (j -i));
//            if (start > end) {
//                while (height[--j]<end && j> i);
//            }else {
//                while (height[++i]<end && j> i);
//            }

//            if (start > end) {
//                j--;
//                while (height[j]<end && j> i){
//                    j--;
//                };
//            }else {
//                i++;
//                while (height[i]<start && j> i){
//                    i++;
//                };
//            }

            if (start > end) {
                do {
                    j--;
                }while (height[j]<end && j> i);
            }else {
                do {
                    i++;
                }while (height[i]<start && j> i);
            }
        }
        return max;




        //网上最快的
//        class Solution {
//            public int maxArea(int[] height) {
//                int max = 0, nmax = 0;
//                int i = 0, j = height.length - 1;
//                int a;
//                while(i < j){
//                    if (height[i] <= height[j]){
//                        nmax =  height[i] * (j - i);
//                        a = height[i];
//                        while(height[++i] <= a && i < j);
//                    }else{
//                        nmax =  height[j] * (j - i);
//                        a = height[j];
//                        while(height[--j] <= a && i < j);
//                    }
//                    if (nmax > max)max = nmax;
//                }
//                return max;
//            }
//        }

    }


    /*
    长度最小的子数组
    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

    示例:

    输入: s = 7, nums = [2,3,1,2,4,3]
    输出: 2
    解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
    进阶:

    如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。*/
    public static int minSubArrayLen(int s, int[] nums) {

/*        第一版:   思路有问题  213
                [12,28,83,4,25,26,25,2,25,25,25,12]*/
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int maxNumber = 0;
//        int maxNumIndex = 0;
//        int total = 0;
//        int length = nums.length;
//        for (int i = 0; i < length; i++){
//            if (nums[i] > maxNumber) {
//                maxNumber = nums[i];
//                maxNumIndex = i;
//            }
//            total += nums[i];
//        }
//
//        if (total < s){
//            return  0;
//        }else if (maxNumber >= s){
//            return maxNumIndex;
//        }
//        int min = 0;
//
//        total = 0;
//        int lenghth1 = 0;
//        // 从 maxIndex 往后遍历
//        for (int number = maxNumIndex; number < length ; number++) {
//            total += nums[number];
//            lenghth1 ++;
//            if (total >= s) {
//                min = lenghth1;
//                break;
//            }
//        }
//        total = 0;
//        int lenghth2 = 0;
//        // 从 maxindex 向前遍历
//        for (int number = maxNumIndex; number >=0 ; number--) {
//            total += nums[number];
//            lenghth2 ++;
//            if (total >= s) {
//                min =min !=0 ? Math.min(min,lenghth2) : lenghth2;
//                break;
//            }
//        }
//        int lenghth3 = 0;
//        if (maxNumIndex != 0 && maxNumIndex != length -1) {
//            lenghth3 = 1;
//            // 从maxIndex 从中间往两边遍历
//            for (int i = maxNumIndex-1 ,j= maxNumIndex+1; j >0 && j< length  && i < length && i>=0 ;i ++,j--) {
//                total += nums[i]+nums[j];
//                lenghth3 +=2;
//                if (total >= s) {
//                    min =min !=0 ? Math.min(min,lenghth3) : lenghth3;
//                    break;
//                }
//            }
//        }
//        return min;

        // 最笨重的方法  第二版
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int maxNumber = 0;
//        int total = 0;
//        int length = nums.length;
//        for (int i = 0; i < length; i++){
//            if (nums[i] > maxNumber) {
//                maxNumber = nums[i];
//            }
//            total += nums[i];
//        }
//
//        if (total < s){
//            return  0;
//        }else if (maxNumber >= s){
//            return 1;
//        }
//
//        int minCont = 0;
//        for (int i = 0; i < length; i++) {
//            total = 0 ;
//            total += nums[i];
//            for (int j = i+1;j < length;j++){
//                total += nums[j];
//                if (total >= s) {
//                    minCont =minCont !=0 ? Math.min(j-i,minCont) :j-i;
//                    break;
//                }
//            }
//        }
//        return ++minCont;

        // copy from leetcode.com
        if (null == nums || nums.length == 0) { return 0; }
        int i = 0, j = 0;
        int sum = 0, minLen = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            if (sum < s) { continue; }
            while (sum >= s) {
                sum -= nums[i];
                i++;
            }
            minLen = Math.min(minLen, j - i + 1);
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;



    }


}
