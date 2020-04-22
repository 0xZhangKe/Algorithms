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
     * 想象成一个二维数组：
     * 第 N 行数据为数组中第 N 个元素，长度为该元素组成 Target 个数；
     * 回溯法通过遍历列进行。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        backtrace(candidates, new ArrayList<>(len * 2), target, 0, result);
        return result;
    }

    private int count = 0;

    /**
     * @return 是否需要继续循环
     */
    private void backtrace(int[] candidates, List<Integer> path, int target, int left, List<List<Integer>> recordList) {
        count++;
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
        System.out.println(sum.count);
    }
}
