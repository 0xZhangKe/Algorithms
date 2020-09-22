package com.zhangke.algorithms.leetcode;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * Created by ZhangKe on 2020/8/20.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount];
        return dp(coins, amount, dp);
    }

    private int dp(int[] coins, int amount, int[] dp) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (dp[amount - 1] != 0) return dp[amount - 1];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int r = dp(coins, amount - coin, dp);
            if (r == -1) continue;
            res = Math.min(res, 1 + r);
        }
        dp[amount - 1] = res == Integer.MAX_VALUE ? -1 : res;
        return dp[amount - 1];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {186, 419, 83, 408};
        System.out.println(coinChange.coinChange(coins, 6249));
    }
}
