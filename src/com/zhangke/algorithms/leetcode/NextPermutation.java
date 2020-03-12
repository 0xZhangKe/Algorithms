package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 * Created by ZhangKe on 2019/12/5.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 0) return;
        int len = nums.length;
        List<Integer> sortList = new ArrayList<>(len);
        for (int item : nums) {
            sortList.add(item);
        }
        sortList.sort((o1, o2) -> o2 - o1);
        boolean isMax = true;
        for (int i = 0; i < len; i++) {
            if (i != sortList.indexOf(nums[i])) {
                isMax = false;
                break;
            }
        }
        if (isMax) {
            for (int i = 0; i < len; i++) {
                nums[i] = sortList.get(len - i - 1);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {1, 4, 2, 3, 1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        Util.printArray(nums);
        System.out.println("spend:" + (System.currentTimeMillis() - start));
    }
}
