package com.zhangke.algorithms.leetcode;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * Created by ZhangKe on 2020/4/19.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis.lengthOfLIS(nums));
    }
}
