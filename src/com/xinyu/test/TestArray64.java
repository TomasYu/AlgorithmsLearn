package com.xinyu.test;

public class TestArray64 {
    public static void main(String[] args) {

        System.out.println(maxPoints(new int[][]{
                {1,1},{2,2},{3,3}

        }));

    }


    /**
     *
     给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。



     提示：

     1 <= points.length <= 300
     points[i].length == 2
     -104 <= xi, yi <= 104
     points 中的所有点 互不相同

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/max-points-on-a-line
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int maxPoints(int[][] points) {

        if (points.length <= 0) {
            return 0;
        }

        int max = 1;
        int cur = 1;
        float angle = 0;
        for (int i = 1; i < points.length; i++) {
            if (angle == 0) {
                angle = (float) (points[i][0] - points[i-1][0]) / (points[i][1] - points[i-1][1]);
                cur ++;
            }else if (angle == (float) (points[i][0] - points[i-1][0]) / (points[i][1] - points[i-1][1])){
                cur++;
            }else {
                angle = 0;
                cur = 0;
            }
            max = Math.max(cur,max);
        }
        return max;
    }
}
