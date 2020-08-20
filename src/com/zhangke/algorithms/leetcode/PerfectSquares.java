package com.zhangke.algorithms.leetcode;

import java.util.Arrays;

/**
 * 279. 完全平方数:
 * https://leetcode-cn.com/problems/perfect-squares/
 * Created by ZhangKe on 2020/4/18.
 */
public class PerfectSquares {

    /**
     * 状态转移方程：dp[i] = Math.min(dp[i],1+dp[i- j*j]) ,i表示当前数字，j*j表示一个平方数
     * 公式解析：
     * 举个栗子， n == 55, 那么可以表示为 49 + 6,49 是个完全平方式，只要计算出 6 的最少完全平方数，
     * 那么 1+这个值 就是 55 的完全平方数。
     */
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                System.out.println(String.format("dp[%s] = %s, dp[%s - square_nums[%s](%s)] + 1 = %s", i, dp[i],
                        i, s, square_nums[s], dp[i - square_nums[s]] + 1));
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(55));
    }
}
