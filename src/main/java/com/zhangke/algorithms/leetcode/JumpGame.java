package com.zhangke.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 55. 跳跃游戏:
 * https://leetcode-cn.com/problems/jump-game/
 * Created by ZhangKe on 2020/4/19.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        return doJump(nums, 0, map);
    }

    private boolean doJump(int[] nums, int position, Map<Integer, Integer> map) {
        if (position >= nums.length - 1) {
            return true;
        }
        int start = position;
        int maxStep = position + nums[position];
        Set<Integer> indexSet = map.keySet();
        for (int item : indexSet) {
            if (item > position && item < position + maxStep) {
                start = item;
                maxStep = map.get(item);
            }
        }
        int maxPosition = start;
        for (int i = start + 1; i < maxStep; i++) {
            if (i >= nums.length) break;
            if ((i + nums[i]) >= maxStep) {
                maxPosition = i;
                maxStep = i + nums[i];
            }
        }
        map.put(maxPosition, maxStep);
        for (int i = nums[maxPosition]; i > 0; i--) {
            if (doJump(nums, maxPosition + i, map)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jg.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(jg.canJump(new int[]{2, 0, 0}));
        System.out.println(jg.canJump(new int[]{2, 0}));
        System.out.println(jg.canJump(new int[]{1, 3, 2}));
        System.out.println(jg.canJump(new int[]{1, 1, 2, 2, 0, 1, 1}));
        System.out.println(jg.canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }
}
