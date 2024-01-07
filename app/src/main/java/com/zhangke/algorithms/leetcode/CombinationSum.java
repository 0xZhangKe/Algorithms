package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和:
 * https://leetcode-cn.com/problems/combination-sum/
 * Created by ZhangKe on 2020/4/17.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        backtrace(candidates, new ArrayList<>(len * 2), target, 0, result);
        return result;
    }

    private void backtrace(int[] candidates, List<Integer> path, int target, int left, List<List<Integer>> recordList) {
        if(target == 0){
            recordList.add(new ArrayList<>(path));
        }
        for (int i = left; i < candidates.length; i++) {
            Integer item = candidates[i];
            if(target < item){
                break;
            }
            path.add(item);
            backtrace(candidates, path, target - item, i, recordList);
            path.remove(item);
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> result = sum.combinationSum(candidates, 7);
        Util.printNestedList(result);
        System.out.println();
    }
}
