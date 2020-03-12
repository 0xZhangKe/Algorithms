package com.zhangke.algorithms.leetcode;

/**
 * 32.最长有效括号：
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * Created by ZhangKe on 2020/1/27.
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        int max = 0;
        char[] array = s.toCharArray();
        int[] dp = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == '(' && array[i] == ')') {
                dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                max = Math.max(dp[i], max);
            } else if (array[i - 1] == ')' && array[i] == ')') {
                int index = i - dp[i - 1] - 1;
                if (index >= 0 && array[index] == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses("(())"));
    }
}
