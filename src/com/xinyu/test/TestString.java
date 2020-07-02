package com.xinyu.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestString {
    /**
     * 复原IP地址
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     *
     * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
     *
     *
     *
     * 示例:
     *
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     */

    public static void main(String[] args) {
        TestString testString = new TestString();
        System.out.println(testString.restoreIpAddresses("010010"));
    }


    //回溯用
    LinkedList<String> linkedList = new LinkedList<>();
    //保存结果用
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        //思路 线转换成数字
        //然后/10  看看能不能满足长度
        //肯定是4次循环 让机器去做事情

        //有一个方法 最小一位 最大三位 255
        //然后从判断一位是不是可以  二位是不是可以 三位是不是可以
        //该方法执行4次  得到结果
        //如果是这样 那么时间复杂度是n^3
        //首先1位的时候 判断总长度够不够
        //2位的时候，判断总长度够不够
        //3位的时候，判断大小 和总长度


        //突然想到  不需要遍历四个  是不是遍历两个就可以？
        //能不能不管？ 直接 3333,3332，这种直接划分  但是没有感觉到充满智慧

        dfs(s,0,0);
        return result;

    }

    public void dfs(String string,int dort,int curIndex){
        //判断点的个数 如果是3个点 都满足 那么就是真的ip  回溯   结束的条件 就是具备三个点
        //对于每一个点  各种情况  如果说其中有一个后续直接不满足 回溯
        //dort * 3 + 3
        //
        //如果当前的index 超过了字符串的长度  返回
        if (curIndex >= string.length()) {
            return;
        }

        //如果当前的字符串是0 那么后面就不能增加字符串了，因为不能出现01.01.01.01 这种
        int max = string.charAt(curIndex) == '0' ? 1 : 3;
        for (int i = 1; i <= max; i++) {
            //保证不要超过整个字符串大小
            if (curIndex + i > string.length()) {
                continue;
            }
            //截取字符串
            String substring = string.substring(curIndex, curIndex + i);
            //如果是合理的字符串 （0<x <255）
            if (!isInvalidate(substring)) {
                continue;
            }
            //增加
            linkedList.add(substring);

            //如果是第三个点 那么就是结束的时候了
            if (dort == 3) {
                //如果当前的长度是整个数组的长度 那么就是结束的时候了
                if (curIndex + substring.length() == string.length()) {
                    //添加结果
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i1 = 0; i1 < linkedList.size(); i1++) {
                        stringBuilder.append(linkedList.get(i1));
                        if (i1 != linkedList.size()-1) {
                            stringBuilder.append(".");
                        }
                    }
                    String e = stringBuilder.toString();
                    result.add(e);
                }
            }else {
                //如果不是最后一个点  那么添加下一个点
                dfs(string,dort + 1,curIndex + substring.length());
            }
            //回溯
            linkedList.pollLast();
        }

    }
    public boolean isInvalidate(String string){
        return string.length() <= 3  && Integer.parseInt(string) <= 255;
    }

}
