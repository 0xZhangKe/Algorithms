package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列:
 * https://leetcode-cn.com/problems/permutations/
 * Created by ZhangKe on 2020/4/26.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> record = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            dfs(nums, new ArrayList<>(), record);
        }
        return record;
    }

    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> record) {
        if (path.size() == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                list.add(nums[path.get(i)]);
            }
            record.add(list);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (path.contains(i)) continue;
                path.add(i);
                dfs(nums, path, record);
                path.remove((Integer) i);
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = {1, 2, 3};
        Util.printNestedList(p.permute(nums));
    }
}
