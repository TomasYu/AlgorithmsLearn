package com.xinyu.test;

public class Test29 {

    public static void main(String[] args) {
        int arr[] = new int[]{7,7,8,8,9,9};
        System.out.println(findSec(arr));


    }

    public static int findSec(int arr[]){
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i-1 > 0) {
                dp[i] = Math.min(dp[i-1],dp[i]);
            }{
                dp[i] = arr[i];
            }
        }
        return dp[arr.length-1];

    }


    public static int findSec2(int arr[]){
        int max = Integer.MIN_VALUE;
        int sec = max;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                sec = max;
                max = arr[i];
            }else if (arr[i] < max){
                if (arr[i] > sec) {
                    sec = arr[i];
                }
            }
        }
        return sec;

    }

}
