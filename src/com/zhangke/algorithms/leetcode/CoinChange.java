package com.zhangke.algorithms.leetcode;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * Created by ZhangKe on 2020/8/20.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        return dp(coins, amount, dp);
    }

    private int dp(int[] coins, int amount, int[] dp) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (dp[amount] != Integer.MAX_VALUE) return dp[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int r = dp(coins, amount - coin, dp);
            if (r == -1) continue;
            res = Math.min(res, 1 + r);
        }
        dp[amount] = res;

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {186, 419, 83, 408};
        System.out.println(coinChange.coinChange(coins, 6249));
    }
}
