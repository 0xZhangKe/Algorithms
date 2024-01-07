package com.zhangke.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/jump-game/">55. 跳跃游戏</a>
 * 从后往前遍历，既然是要跳到最后一个 index，那么就从最后一个 index 开始，找到能跳到这个 index 的 index，
 * 然后再将这个 index 作为目标重复搜索。
 * 最终如果能跳转到数组开头，那么从开头就可以跳到末尾，因为有重复步骤，所以加个缓存。
 * Created by ZhangKe on 2020/4/19.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        return canJump(nums, nums.length - 1, new HashMap<>());
    }

    private boolean canJump(int[] nums, int targetIndex, Map<Integer, Boolean> cache) {
        if (targetIndex == 0) return true;
        if (cache.containsKey(targetIndex)) return cache.get(targetIndex);
        for (int i = targetIndex - 1; i >= 0; i--) {
            if (i + nums[i] >= targetIndex && canJump(nums, i, cache)) {
                cache.put(i, true);
                return true;
            }
        }
        cache.put(targetIndex, false);
        return false;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
//        System.out.println(jg.canJump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(jg.canJump(new int[]{3, 2, 1, 0, 4}));
//        System.out.println(jg.canJump(new int[]{2, 0, 0}));
//        System.out.println(jg.canJump(new int[]{2, 0}));
//        System.out.println(jg.canJump(new int[]{1, 3, 2}));
//        System.out.println(jg.canJump(new int[]{1, 1, 2, 2, 0, 1, 1}));
//        System.out.println(jg.canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
        System.out.println(jg.canJump(new int[]{2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6}));
    }
}
