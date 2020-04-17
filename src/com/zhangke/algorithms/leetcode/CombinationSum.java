package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 39. 组合总和:
 * https://leetcode-cn.com/problems/combination-sum/
 * Created by ZhangKe on 2020/4/17.
 */
public class CombinationSum {

    /**
     * 想象成一个二维数组：
     * 第 N 行数据为数组中第 N 个元素，长度为该元素组成 Target 个数；
     * 回溯法通过遍历列进行。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        backtrace(candidates, new ArrayList<>(len * 2), target, result);
        return result;
    }

    private void backtrace(int[] candidates, List<Integer> path, int target, List<List<Integer>> recordList) {
        for (int i = 0; i < candidates.length; i++) {
            Integer item = candidates[i];
            if (item == target) {
                if (path.isEmpty()) {
                    recordList.add(Collections.singletonList(item));
                } else {
                    List<Integer> list = new ArrayList<>(path);
                    list.add(item);
                    recordList.add(list);
                }
            } else if (item < target) {
                path.add(item);
                backtrace(candidates, path, target - item, recordList);
                path.remove(item);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        int[] candidates = new int[]{7, 3, 2};
        List<List<Integer>> result = sum.combinationSum(candidates, 18);
        Util.printNestedList(result);
    }
}
