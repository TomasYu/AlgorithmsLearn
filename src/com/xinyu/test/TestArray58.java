package com.xinyu.test;

import java.util.ArrayList;
import java.util.List;

public class TestArray58 {
    public static void main(String[] args) {
        TestArray58 testArray58 = new TestArray58();
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list.add(list1);


        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list.add(list2);


        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list.add(list3);


        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list4);


        System.out.println(testArray58.minimumTotal(list));
    }

    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     *
     *
     *
     * 例如，给定三角形：
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     *
     *
     * 说明：
     *
     * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     *
     *
     * [[-1],
     * [2,3],
     * [1,-1,-3]]
     */

    public int minimumTotal(List<List<Integer>> triangle) {

//        return sum;
        //使用递归  对于最顶层的三星形  最大值为顶角 加上 两个孩子当中的最大值
        //每一个子孩子的最大值 又等于下面两个孩子的最大值
        // fmax（A） = fmax(left) + fmax(right)
        //最小值也同理
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        List<Integer> integers = triangle.get(0);
        if (integers == null || integers.size() == 0) {
            return 0;
        }
        int dp[][]  =new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        return integers.get(0) + miniIndex(1,triangle,0,dp);
    }

    public int miniIndex(int floor,List<List<Integer>>  listList,int mCurIndex,int dp[][]){
        if (listList == null || floor >= listList.size()) {
            return 0;
        }
        if (dp[floor][mCurIndex] != 0) {
            return dp[floor][mCurIndex];
        }
        List<Integer> integers = listList.get(floor);
        int min = Math.min(integers.get(mCurIndex) + miniIndex(floor + 1, listList, mCurIndex, dp), integers.get(mCurIndex + 1) + miniIndex(floor + 1, listList, mCurIndex + 1, dp));
        dp[floor][mCurIndex] = min;
        return min;
    }
}
