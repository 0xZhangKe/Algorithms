package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * 78. 子集
 * <a href="https://leetcode.cn/problems/subsets/?favorite=2cktkvj">78. 子集</a>
 * <p>
 * 既然是所有子集，那么长度一定是从0开始到数组长度的，首先遍历这个区间，然后找到这个长度的所有子集。
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets s = new Subsets();
        ListUtils.INSTANCE.printList(s.subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = findThisLenSubsets(nums, i);
            result.addAll(list);
        }
        return result;
    }

    private List<List<Integer>> findThisLenSubsets(int[] nums, int len) {
        if (len == 0) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        while (indexes[0] < nums.length - len) {
            List<Integer> list = new ArrayList<>(len);
            for (int i : indexes) {
                list.add(nums[i]);
            }
            result.add(list);
            for (int i = len - 1; i >= 0; i--) {
                int currentIndex = indexes[i];
                if (currentIndex < nums.length - i - 1) {
                    for (int j = i; j < indexes.length; j++) {
                        indexes[j] = indexes[i] + j + 1;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
