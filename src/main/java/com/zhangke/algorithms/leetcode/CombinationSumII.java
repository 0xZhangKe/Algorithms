package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II:
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * Created by ZhangKe on 2020/4/24.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        backtrace(candidates, new ArrayList<>(len * 2), target, target, 0, result);
        return result;
    }

    private void backtrace(int[] candidates, List<Integer> path, int target, int originalTarget, int left, List<List<Integer>> recordList) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>(path);
//            if (left > 0 && left < candidates.length && candidates[left] == candidates[left - 1]) {
//                if (!recordList.contains(list)) {
//                    recordList.add(list);
//                }
//            } else {
//                recordList.add(list);
//            }
            if (!recordList.contains(list)) {
                recordList.add(list);
            }
        }
        for (int i = left; i < candidates.length; i++) {
            Integer item = candidates[i];
            if (target < item) {
                break;
            }
            if (target == originalTarget && i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            System.out.println("i:" + i + ", left:" + left);
            path.add(item);
            backtrace(candidates, path, target - item, originalTarget, i + 1, recordList);
            path.remove(item);
        }
    }

    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();
        int[] candidates = {2, 5, 2, 1, 2};
        Util.printNestedList(cs.combinationSum2(candidates, 5));
    }
}
