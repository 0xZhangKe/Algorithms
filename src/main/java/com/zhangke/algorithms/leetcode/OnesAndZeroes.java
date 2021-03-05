package com.zhangke.algorithms.leetcode;

/**
 * 474. 一和零:
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 * Created by ZhangKe on 2020/10/10.
 */
public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        // 状态：m,n 的值，从 0 开始遍历
        // 选择：是否选择组成该字符串
        // dp[m][n] = 组成的个数
        // BaseCase：dp[0][0] = 0
        // 状态转移方程：
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0) continue;

            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        OnesAndZeroes oaz = new OnesAndZeroes();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(oaz.findMaxForm(strs, 5, 3));
    }
}
