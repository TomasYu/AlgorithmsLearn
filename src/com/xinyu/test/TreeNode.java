package com.xinyu.test;

/**
 * Created by zy on 2020/4/3.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }


    public String getSum(String s1, String s2) {
        int offset = 'A';
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        int size = Math.max(s1Array.length,s2Array.length)+1;
        char[] result = new char[size];
        int temp = 0;
        int s1Length = s1Array.length;
        int s2Length = s2Array.length;
        boolean needAddOne = false;
        int i = 0;
        int a = 0;
        int b = 0;
        while(i < s1Length || i< s2Length){
            a = s1Length - i > 0 ? s1Array[s1Length - i] : 0;
            b = s1Length - i > 0 ? s2Array[s1Length - i] :0;
            temp =  a+ b - offset * 2 + (needAddOne ? 1:0);
            if( temp > 10 ){
                needAddOne = true;
                temp -=10;
            }else{
                needAddOne = false;
            }
            result[i] = (char) (temp + offset);
        }
        return new String(result);

    }

    public static String main(String text) {
        char[] str = text.toCharArray();
        int[] bucket = new int[128];
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str) {
            if (bucket[c] == 0) {
                stringBuilder.append(c);
                bucket[c] ++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String result = main("BBCCAB");
        System.out.println(result);

    }
}
