package com.xinyu.test;

public class TestArray112 {


    /**
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
     *
     * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
     *
     * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
     *
     * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,7,4,9,2,5]
     * 输出：6
     * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
     * 示例 2：
     *
     * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
     * 输出：7
     * 解释：这个序列包含几个长度为 7 摆动序列。
     * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
     * 示例 3：
     *
     * 输入：nums = [1,2,3,4,5,6,7,8,9]
     * 输出：2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int wiggleMaxLength(int[] nums) {
        int dp[][] =new int[nums.length][2];
        //0 最长的上涨结尾
        //1  最长的上涨结尾
        for (int i = 1; i < nums.length; i++) {
            //涨
            if (nums[i] > nums[i-1]) {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][0] + 1;
            }else if (nums[i] == nums[i-1]){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
            }else {
                //跌
                dp[i][0] = dp[i-1][1] + 1;
                dp[i][1] = dp[i-1][1];
            }
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]) + 1;
    }


    public int wiggleMaxLength2(int[] nums) {
        //
        if (nums.length < 2){
            return nums.length;
        }
        int curUp = 0;
        int preUp = 0;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                if (preUp == -1 || preUp == 0) {
                    result++;
                }
                preUp = nums[i] > nums[i-1] ? 1 : -1;

            }else if (nums[i] == nums[i-1]){

            }else {
                if (preUp == 1  || preUp == 0) {
                    result++;
                }
                preUp = nums[i] > nums[i-1] ? 1 : -1;

            }

        }
        return result + 1;

    }

    public static void main(String[] args) {
        TestArray112 testArray112s = new TestArray112();
        System.out.println(testArray112s.wiggleMaxLength2(new int[]{3, 3, 3, 2, 5}));
    }
}
