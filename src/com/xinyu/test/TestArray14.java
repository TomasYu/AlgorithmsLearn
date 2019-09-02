package com.xinyu.test;

/**
 * Created by zy on 2019/4/16.
 */
public class TestArray14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aflower","flow","flight"}));
    }


    /**
     *
     *
     *
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:

     所有输入只包含小写字母 a-z 。
     */
//    public static String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        if (strs.length == 1){
//            return strs[0];
//        }
//
//        String str = strs[0];
//        StringBuilder sb = new StringBuilder();
//        out : for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if (i >= strs[j].length()) {
//                    break out;
//                }
//
//                if (c != strs[j].charAt(i)) {
//                    break out;
//                }
//            }
//            sb.append(c);
//        }
//
//        return sb.toString();
//
//    }


    public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length<1){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        //find the shortest string
        int shortest=0;
        int len=strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if(len > strs[i].length()){
                len=strs[i].length();
                shortest=i;
            }
        }
        //find the longest common prefix
        String sub=strs[shortest];
        for (int i = 0; i < strs.length; i++) {
            while(strs[i].indexOf(sub)!=0){
                sub=sub.substring(0, sub.length()-1);

            }
            if (sub.equals("")) {
                break;
            }
        }
        return sub;

    }


}
