package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 39. 组合总和:
 * https://leetcode-cn.com/problems/combination-sum/
 * Created by ZhangKe on 2020/4/17.
 */
public class CombinationSum {

    /**
     * 排序;
     * 开始遍历数组:
     * 如果数值小于 Target:
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int item = candidates[i];
            if (item > target) break;
            if (target % item == 0) {
                addRecord(item, target / item, 0, 0, result);
            }
            int secondValueIndex = i + 1;
            while (secondValueIndex < len && candidates[secondValueIndex] < target) {
                addTwoValueForTarget(item, candidates[secondValueIndex], target, result);
                secondValueIndex++;
            }
        }
        return result;
    }

    private void addTwoValueForTarget(int first, int second, int target, List<List<Integer>> record) {
        int firstMax = target / first;
        for (int firstCount = 1; firstCount <= firstMax; firstCount++) {
            int diff = target - first * firstCount;
            int secondCount = diff / second;
            if (diff % second == 0 && secondCount != 0) {
                addRecord(first, firstCount, second, secondCount, record);
            }
        }
    }

    private void addRecord(int first, int firstCount, int second, int secondCount, List<List<Integer>> record) {
        if (firstCount == 0 && secondCount == 0) return;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < firstCount; i++) {
            result.add(first);
        }
        for (int i = 0; i < secondCount; i++) {
            result.add(second);
        }
        record.add(result);
    }

    private void divide(int value, int target, List<Integer> lineRecord) {
        if (target % value == 0) {
            int count = target / value;
            for (int i = 0; i < count; i++) {
                lineRecord.add(value);
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
