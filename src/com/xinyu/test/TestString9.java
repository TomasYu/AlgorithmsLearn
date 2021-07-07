package com.xinyu.test;

import java.util.*;

public class TestString9 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("12"));
    }

    /**
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        for (char aChar : chars) {
            if (result.isEmpty()) {
                result.addAll(get(aChar));
            }else {
                List<String> strings = get(aChar);
                List<String> temp = new ArrayList<>();
                for (String s : result) {
                    for (String string : strings) {
                        temp.add(s + string);
                    }
                }
                result = temp;
            }

        }
        return result;
    }

    public static List<String> get(char input){
        switch (input) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");

            case '5':
                return Arrays.asList("j", "k", "l");

            case '6':
                return Arrays.asList("m", "n", "o");

            case '7':
                return Arrays.asList("p", "q", "r","s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y","z");
        }
        return Arrays.asList("");
    }
}
