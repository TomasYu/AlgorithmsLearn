package com.xinyu.test;

import java.util.ArrayList;
import java.util.List;

public class TestString14 {

    /**
     * https://blog.csdn.net/kexuanxiu1163/article/details/105630100/
     *
     * 93. 复原 IP 地址
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * 示例 2：
     *
     * 输入：s = "0000"
     * 输出：["0.0.0.0"]
     * 示例 3：
     *
     * 输入：s = "1111"
     * 输出：["1.1.1.1"]
     * 示例 4：
     *
     * 输入：s = "010010"
     * 输出：["0.10.0.10","0.100.1.0"]
     * 示例 5：
     *
     * 输入：s = "101023"
     * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     */

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backTrace(s,0,0,result);
        return result;
    }

    public void backTrace(String s,int curIndex,int count,List<String> result){
        if (count == 3){
            if (isValiad(s,curIndex,s.length()-1)){
                result.add(s);
            }
            return;
        }

        for (int i = curIndex ; i < s.length(); i++) {
            if (isValiad(s,curIndex,i)){
                s = s.substring(0,i+1) + "." + s.substring(i + 1);
                backTrace(s,i+2,count+1,result);
                s = s.substring(0,i+1)  + s.substring(i + 2);
            }else {
                break;
            }
        }

    }

    public boolean isValiad(String s , int start ,int end){
        if (start > end) {
            return false;
        }

        if (end - start > 3){
            return false;
        }

        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        //<255
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TestString14 testString14 = new TestString14();
        List<String> strings = testString14.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }


}
