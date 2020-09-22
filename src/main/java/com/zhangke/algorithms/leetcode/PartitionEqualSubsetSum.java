package com.zhangke.algorithms.leetcode;

/**
 * 416. 分割等和子集:
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * Created by ZhangKe on 2020/9/8.
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target + 1];
        if(nums[0] < target){
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i] < j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum pes = new PartitionEqualSubsetSum();
        System.out.println(pes.canPartition(new int[]{100}));
    }
}
