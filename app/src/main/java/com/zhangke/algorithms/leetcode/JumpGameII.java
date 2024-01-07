package com.zhangke.algorithms.leetcode;

public class JumpGameII {

    public static void main(String[] args) {
        JumpGameII jumpGame = new JumpGameII();
        System.out.println(jumpGame.jump(new int[]{2,3,0,1,4}));
    }

    public int jump(int[] nums) {
        int count = 0;
        int index = nums.length - 1;
        while (index > 0) {
            index = findMinIndex(nums, index);
            count++;
            System.out.println(index);
        }
        return count;
    }

    private int findMinIndex(int[] nums, int index) {
        if (index == 0) return 0;
        int minIndex = index;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] + i >= index) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
