package com.xinyu.test;

import java.util.ArrayDeque;
import java.util.HashMap;

public class TestString13 {

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     *
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     * 示例 4：
     *
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     *
     * 输入：s = "{[]}"
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     */

    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();
        HashMap<Character,Character> hashMap = new HashMap();
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');
        ArrayDeque<Character> arrayDeque = new ArrayDeque();

        for (int i = 0; i < chars.length; i++) {
            if (arrayDeque.peek() != null && hashMap.get(arrayDeque.peek()) !=null && hashMap.get(arrayDeque.peek()) == chars[i]) {
                arrayDeque.pop();
            }else {
                arrayDeque.push(chars[i]);
            }
        }
        return arrayDeque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));

    }
}
