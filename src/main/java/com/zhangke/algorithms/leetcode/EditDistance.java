package com.zhangke.algorithms.leetcode;

/**
 * 72. 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 * Created by ZhangKe on 2020/9/27.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = i;
        for (int j = 0; j < n; j++)
            dp[0][j] = j;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lastStepValue = i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = lastStepValue;
                } else {
                    dp[i][j] = min(
                            (i > 0 ? dp[i - 1][j] : 0) + 1,
                            (j > 0 ? dp[i][j - 1] : 0) + 1,
                            lastStepValue + 1
                    );
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private int min(int v1, int v2, int v3) {
        return Math.min(v1, Math.min(v2, v3));
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("intention", "execution"));
    }
}
