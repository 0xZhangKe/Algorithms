package com.zhangke.algorithms.leetcode;

import java.util.Arrays;

/**
 * 887. 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 * Created by ZhangKe on 2020/9/29.
 */
public class SuperEggDrop {

    public int superEggDrop(int K, int N) {
        // 状态：当前鸡蛋剩余个数，剩余楼层数
        // 选择：选择哪个楼层进行测试
        // BaseCase：只有一个鸡蛋时只能线性扫描，需要 N 次，其他设置为 0
        // 状态转移：鸡蛋摔碎则剩余鸡蛋数-1,剩余楼层数-1；未摔碎则剩余楼层数-1取两者最小值
        int[][] dp = new int[K + 1][N + 1];
        if (K > 1) {
            Arrays.fill(dp[1], N);
        }
        for (int i = 1; i <= K; i++) {
            int res;
            for (int j = 1; j <= N; j++) {
                if (dp[i][j] != 0) continue;
                dp[i][j] = Math.max(
                        dp[i - 1][j - 1],// 碎了
                        dp[i][j - i]// 没碎
                ) + 1;
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        SuperEggDrop sed = new SuperEggDrop();
        System.out.println(sed.superEggDrop(1, 2));
    }
}