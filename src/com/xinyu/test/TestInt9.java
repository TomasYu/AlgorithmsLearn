package com.xinyu.test;

import java.util.Arrays;

public class TestInt9 {

    /**
     * 204. 计数质数
     * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 10
     * 输出：4
     * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * 示例 2：
     *
     * 输入：n = 0
     * 输出：0
     * 示例 3：
     *
     * 输入：n = 1
     * 输出：0
     * @return
     */

    public int countPrimes(int n) {
        //init result
        int result = 0;
        //loop
        boolean needAdd = true;

        for (int i = 2; i < n; i++) {
            needAdd = true;
            // loop from 2 to x
            for (int j = 2; j * j <= i;j++){
                //if %=0 return false
                if (i % j == 0){
                    needAdd = false;
                    break;
                }
            }
            if (needAdd) {
                result ++;
                System.out.println(i);
            }

        }
        //return result
        return result;
    }

    public int countPrimes2(int n){
        //create cache
        int[] ints = new int[n];
        //fill  1
        Arrays.fill(ints,1);
        //for 2...n
        int result = 0;
        for (int i = 2;i < n;i ++){
            //if cache[i] == 1  set i*i = 0 then i=i*i+i
            if (ints[i] == 1){
                System.out.println(i);
                result++;
                //负数会搞乱质数的工作进程  因为会发生 j += i
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        ints[j] = 0;
                    }
                }

            }
        }
        return result;
    }


    public static void main(String[] args) {
        TestInt9 testInt9 = new TestInt9();
        System.out.println(testInt9.countPrimes2(71056));
    }
}
