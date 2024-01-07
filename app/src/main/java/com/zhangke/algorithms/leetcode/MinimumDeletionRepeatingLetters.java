package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.Assert;

/**
 * 1578. 避免重复字母的最小删除成本:
 * https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 * Created by ZhangKe on 2021/3/12.
 */
public class MinimumDeletionRepeatingLetters {

    public int minCost(String s, int[] cost) {
        char[] chars = s.toCharArray();
        int summary = 0;
        int lastEqualsIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            boolean end = i == chars.length - 1;
            char nextChar = end ? 0 : chars[i + 1];
            if (!end && curChar == nextChar) {
                if (lastEqualsIndex == -1) lastEqualsIndex = i;
            } else if (lastEqualsIndex >= 0 && lastEqualsIndex < i) {
                int[] args = new int[i - lastEqualsIndex + 1];
                for (int j = lastEqualsIndex; j <= i; j++) {
                    args[j - lastEqualsIndex] = cost[j];
                }
                summary += min(args);
                lastEqualsIndex = -1;
            } else {
                lastEqualsIndex = -1;
            }
        }
        return summary;
    }

    private int min(int... args) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int a : args) {
            max = Math.max(a, max);
            sum += a;
        }
        return sum - max;
    }

    public static void main(String[] args) {
//        case1();
//        case2();
        case3();
        case4();
    }

    private static void case1() {
        MinimumDeletionRepeatingLetters mdrl = new MinimumDeletionRepeatingLetters();
        int[] cost = {1, 2, 3, 4, 5};
        Assert.assertEquals(mdrl.minCost("abaac", cost), 3);
    }

    private static void case2() {
        MinimumDeletionRepeatingLetters mdrl = new MinimumDeletionRepeatingLetters();
        int[] cost = {1, 2, 3};
        Assert.assertEquals(mdrl.minCost("abc", cost), 0);
    }

    private static void case3() {
        MinimumDeletionRepeatingLetters mdrl = new MinimumDeletionRepeatingLetters();
        int[] cost = {1, 2, 3, 4, 1};
        Assert.assertEquals(mdrl.minCost("aabaa", cost), 2);
    }

    private static void case4() {
        MinimumDeletionRepeatingLetters mdrl = new MinimumDeletionRepeatingLetters();
        int[] cost = {3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1};
        System.out.println(mdrl.minCost("aaabbbabbbb", cost));
    }
}
