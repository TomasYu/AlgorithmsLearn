package com.xinyu.test;

import java.util.Arrays;
import java.util.HashMap;

public class TestArray48 {

    public static void main(String[] args) {
//        System.out.println(rob(new int[]{1, 1, 1, 1, 99, 1}));
//        System.out.println(rob(new int[]{1, 55, 1,1, 55, 1}));
//        System.out.println(rob(new int[]{1,20,1,30, 25}));
        System.out.println(rob2(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{1,1,20,30, 25}));
        System.out.println(rob2(new int[]{1,1,20,30, 25}));
        System.out.println(rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
        System.out.println(rob2(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }

    /**
     * 打家劫舍
     *
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     */

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
        }
        return dp[N];
    }


    /**
     * 思路：
     * 如果只有一家  那就不用说了 最高肯定是这个
     * 如果是有两家 那么选最高的那家
     *
     * 如果是三家 那么要么是中间一家  要么是左右两家相加
     *
     * 假设我们一共有n家 那么最大值要么是前n-1 家的最大值
     * 要么是n-2 家的最大值  加上第n 家的值
     *
     *
     *
     */

    /**
     *
     * @param nums
     * @return
     */
    static int num = 0;
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static int rob2(int[] nums) {
        map.clear();
        int i = reb3(nums, nums.length);
        return i;

    }

    public static int reb3(int[] nums,int length){
        num ++;
        if (length == 0) {
            return 0;
        }else if (length == 1){
            return nums[0];
        }else if (length == 2){
            return Math.max(nums[0],nums[1]);
        }
        Integer orDefault = map.getOrDefault(length, -1);
        if (orDefault != -1) {
            return orDefault;
        }
        int max = Math.max(reb3(nums, length - 1), reb3(nums, length - 2) + nums[length - 1]);
        map.put(length,max);
        return max;

    }

}
