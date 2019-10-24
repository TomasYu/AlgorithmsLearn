package com.xinyu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray17 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }


    /**
     *
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

     说明：解集不能包含重复的子集。

     示例:

     输入: nums = [1,2,3]
     输出:
     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]

     *
     *
     */

    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        genSubset(list,lists);
//        return lists;

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;

    }

    public static void genSubset(List<Integer> list,List<List<Integer>> lists){
        lists.add(list);

    }

    public static void genSubset(int start,int next,List<Integer> list,List<List<Integer>> lists){
        lists.add(list);

    }


}
