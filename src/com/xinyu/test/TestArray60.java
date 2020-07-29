package com.xinyu.test;

public class TestArray60 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap(new int[]{4,2,3}));
    }

    /**
     * 接雨水
     给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

     示例:

     输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     输出: 6


     */

    static class Solution {
        public int trap(int[] height) {
            /**
             *
             左右两边  积水的高度取决于短的一端
             如果左边的低  那么我们就从左边开始遍历
             默认左边最大的值为最左边的值 如果比最大值小，那么这个值和最大值的差值就可以直接放到结果里面
             否则  更新左边的最大值
             右边亦然
             */
            if (height.length == 0) {
                return 0;
            }
            int result = 0 ;
            int left = 0,right = height.length -1;
            int leftMax = height[left],rightMax = height[right];
            while (left < right) {
                if (height[left] > height[right]){
                    if (height[right]< height[rightMax]) {
                        result += height[rightMax] - height[right];
                    }else {
                        rightMax = right;
                    }
                    right --;
                }  else {
                   if (height[left] > height[leftMax]){
                       leftMax = left;
                   }else {
                        result += height[leftMax] - height[left];
                   }
                   left++;

                }
            }
            return result;
        }
    }
}
