package com.xinyu.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestString12 {

    public static void main(String[] args) {
        TestString12 testString12 = new TestString12();
        System.out.println(testString12.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。
     *
     * 说明：拆分时可以重复使用字典中的单词。
     *
     * 示例 1：
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * 示例 2：
     *
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     *      注意你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * https://programmercarl.com/%E5%85%B6%E4%BB%96/%E4%BB%8B%E7%BB%8D.html
     *
     * https://leetcode-cn.com/problems/word-break/solution/dai-ma-sui-xiang-lu-139-dan-ci-chai-fen-50a1a/
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);
        int length = s.length();
        boolean [] dp = new boolean[length+1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];

    }

}
