package com.xinyu.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestString4 {
    /**
     *  翻转字符串里的单词
     *
     *
     *  给定一个字符串，逐个翻转字符串中的每个单词。
     *
     *
     *
     * 示例 1：
     *
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     *
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     *
     * 说明：
     *
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     *
     * 进阶：
     *
     * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
     *
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world!  "));


        //split 方法
        /**
         *
         1.如果字符串最前面有匹配的字符串  则返回的字符串数组 第一个为空

         System.out.println(Arrays.toString("-1".split("-")));
         [, 1]

         2.如果limit 为 0 ,后续分割的字符串长度小于0，那么后续的字符串就不会继续返回
         System.out.println(Arrays.toString("  hello world!  ".split(" ")));
         [, , hello, world!]

         System.out.println(Arrays.toString("3-2-abc---".split("-")));
         [3, 2, abc]

         System.out.println(Arrays.toString("aaaa".split("a")));
         []
         这个因为是所有的元素都是空，而且limit 是 0  所以返回的就是空的 具体可以看下源码

         System.out.println(Arrays.toString("-1---".split("-")));
         [, 1]

         3.如果没有匹配到字符串，则返回整个字符串  不关心limit 参数
         System.out.println(Arrays.toString("-1---1-1-".split("c",2)));
         [-1---1-1-]

         4.如果设置了limit,那么返回的最长长度就是limit  最后一个为没有分割的后续字符串

         System.out.println(Arrays.toString("-1---1-1-".split("-",1)));
         [-1---1-1-]

         System.out.println(Arrays.toString("-1---1-1-".split("-",2)));
         [, 1---1-1-]


         5.如果limit 不为 0 ,后续分割的字符串长度小于0，后续的字符串也会继续返回
         System.out.println(Arrays.toString("-1--".split("-",4)));
         [, 1, , ]

         6.如果limit 不为 0 ,且设置的长度大于分割后整个数组的长度，后续的字符串也会继续返回
         System.out.println(Arrays.toString("-1--".split("-",5)));
         [, 1, , ]

         7.如果分割得到的所有字符串都是空串 那么返回的结果数组是空的
         System.out.println(Arrays.toString("aaaa".split("a")));
         []

         8.如果limit 为1 那么直接返回整个字符串,不管是不是找到了子串，具体原因看源码
         System.out.println(Arrays.toString("-1---1-1-".split("1",1)));
         [-1---1-1-]
         System.out.println(Arrays.toString("-1---1-1-".split("a",1)));
         [-1---1-1-]


         */
        System.out.println(Arrays.toString("  hello world!  ".split(" ")));
        System.out.println(Arrays.toString("a good     example".split(" ")));
        System.out.println(Arrays.toString("--".split("-")));
        System.out.println(Arrays.toString("-1---".split("-")));
        System.out.println(Arrays.toString("-1".split("-")));
        System.out.println(Arrays.toString("-1---1-".split("-")));
        System.out.println(Arrays.toString("---1---1-".split("-")));
        System.out.println(Arrays.toString("-1---1-".split("a")));
        System.out.println(Arrays.toString(" ".split(" ")));
        System.out.println(Arrays.toString(" ".split("")));
        System.out.println(Arrays.toString("abc".split("")));

        System.out.println(Arrays.toString("-1---1-1-".split("c",2)));
        System.out.println(Arrays.toString("-1---1-1-".split("-",1)));
        System.out.println(Arrays.toString("-1---1-1-".split("-",2)));
        System.out.println(Arrays.toString("-1-1-1-".split("-",4)));
        System.out.println(Arrays.toString("--11-1-".split("-",4)));
        System.out.println(Arrays.toString("--11-1-".split("-",3)));
        System.out.println(Arrays.toString("--11-1--------".split("-",20)));
        System.out.println(Arrays.toString("--11-1--------".split("-",0)));
        System.out.println(Arrays.toString("-1--".split("-",0)));
        System.out.println(Arrays.toString("-1--".split("-",2)));
        System.out.println(Arrays.toString("-1--".split("-",3)));
        System.out.println(Arrays.toString("-1--".split("-",4)));
        System.out.println(Arrays.toString("-1--".split("-",5)));
        System.out.println(Arrays.toString("3-2-abc---".split("-")));
        System.out.println(Arrays.toString("aaaa".split("a")));
        System.out.println(Arrays.toString("aaaa".split("a",3)));
        System.out.println(Arrays.toString("aaaa".split("a",4)));
        System.out.println(Arrays.toString("aaaa".split("a",5)));
        System.out.println(Arrays.toString("aaaa".split("a",6)));

        System.out.println(Arrays.toString("-1---1-1-".split("1",1)));
        System.out.println(Arrays.toString("-1---1-1-".split("a",1)));



        char a = '-';

    }

    static class Solution {
        public String reverseWords(String s) {
            String[] split = s.split(" ");
            //todo 怎么翻转数组？
            List<String> strings = Arrays.asList(split);
            Collections.reverse(strings);
            String join = String.join(" ", strings);

            return join;
        }
    }


}
