package com.zhangke.algorithms.leetcode;

/**
 * 518. 零钱兑换 II:
 * https://leetcode-cn.com/problems/coin-change-2/
 * Created by ZhangKe on 2020/9/10.
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            System.out.println("coin:" + coin);
            for (int x = coin; x < amount + 1; ++x) {
                System.out.println("    x:" + x + ", x - coin = " + (x - coin));
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 cc = new CoinChange2();
        System.out.println(cc.change(5, new int[]{1, 2, 5}));
    }
}
