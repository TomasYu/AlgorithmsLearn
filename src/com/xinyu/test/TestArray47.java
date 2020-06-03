package com.xinyu.test;

import java.util.Arrays;
import java.util.HashMap;

public class TestArray47 {

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     *
     *
     * 示例 1:
     *
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * 示例 2:
     *
     * 输入: coins = [2], amount = 3
     * 输出: -1
     *
     *
     * 说明:
     * 你可以认为每种硬币的数量是无限的。
     */
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = rcoinChange(coins, amount,map);
        return i == Integer.MAX_VALUE ? -1 : i ;
    }

    public int rcoinChange(int[] conins,int amount,HashMap<Integer,Integer> map){
        Integer orDefault = map.getOrDefault(amount, null);
        if (orDefault != null) {
            return orDefault;
        }
        int min = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }
        if (amount <0){
            return Integer.MAX_VALUE;
        }
        for (int i = 0; i < conins.length; i++) {
            int change = rcoinChange(conins, amount - conins[i],map);
            if (change == Integer.MAX_VALUE) {
//                return -1;
            }else {
                int rcoinChange = change + 1;
                min = Math.min(rcoinChange,min);
            }

        }
        map.put(amount,min);
        return min;
    }


    //方法最好
    int ans=Integer.MAX_VALUE;
    public int coinChange2(int[] coins, int amount) {
        //排序
        Arrays.sort(coins);
        dfs(coins,coins.length-1,amount,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public void dfs(int[] coins,int index,int amount,int cnt){
        if(index<0){
            return;
        }
        //优先使用金额最大的值
        for(int c=amount/coins[index];c>=0;c--){

            int na=amount-c*coins[index];
            int ncnt=cnt+c;
            if(na==0){
                //如果说这里等于0 说明能够组成当前要求的值
                ans=Math.min(ans,ncnt);
                break;//剪枝1
            }
            //如果走到这一步 已经比之前的方法路径长了 那么不需要再遍历了
            if(ncnt+1>=ans){
                break; //剪枝2
            }
            dfs(coins,index-1,na,ncnt);
        }
    }



}
