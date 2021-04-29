package com.xinyu.test;

public class TestArray110 {

    static class Solution {
        public int maxTurbulenceSize(int[] arr) {
             boolean up = false;
             boolean first = false;
            int maxLen = 0;
            int curLen =1;
            for (int i = 0 ; i < arr.length;i++){
                if (i + 1 < arr.length) {
                    if (!first) {
                        if (arr[i] == arr[i+1]) {
                            continue;
                        }
                        first = true;
                        up = arr[i] > arr[i+1];

                        curLen ++;
                    }else {

                        if (arr[i] == arr[i+1]) {
                            maxLen = Math.max(curLen,maxLen);
                            curLen = 1;
                            up = arr[i] > arr[i+1];
                            continue;
                        }
                        if (arr[i] > arr[i+1] == !up) {
                            curLen ++;
                            up = !up;
                        }else {
                            if (arr[i] == arr[i+1]) {

                            }else {
                                maxLen = Math.max(curLen,maxLen);
                                up = arr[i] > arr[i+1];
                                curLen = 2;
                            }

                        }
                    }
                }

            }
            maxLen = Math.max(curLen,maxLen);

            return maxLen;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxTurbulenceSize(new int[]{8,8,9,10,6,8,2,4,2,2,10,6,6,10,10,2,3,5,1,2,10,4,2,0,9,4,9,3,0,6,3,2,3,10,10,6,4,6,4,4,2,5,1,4,1,1,9,8,9,5,3,5,5,4,5,5,6,5,3,3,7,2,0,10,9,7,7,3,5,1,0,9,6,3,1,3,4,4,3,6,3,2,1,4,10,2,3,4,4,3,6,7,6,2,1,7,0,6,8,10});
//        int i = solution.maxTurbulenceSize(new int[]{9, 9});
        System.out.println(i);
    }
}
