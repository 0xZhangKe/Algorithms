package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18.四数之和：https://leetcode-cn.com/problems/4sum/
 * Created by ZhangKe on 2019/9/6.
 */
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int a;
        int b;
        int c;
        int d;
        int sum;
        for (a = 0; a < len - 3; a++) {
            for (b = a + 1; b < len - 2; b++) {
                d = len - 1;
                c = b + 1;
                while (c != d) {
                    sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        List<Integer> itemList = new ArrayList<>();
                        itemList.add(nums[a]);
                        itemList.add(nums[b]);
                        itemList.add(nums[c]);
                        itemList.add(nums[d]);
                        if (!list.contains(itemList)) {
                            list.add(itemList);
                        }
                        c++;
                    } else if (sum > target) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        Sum4 sum = new Sum4();
        Util.printNestedList(sum.fourSum(nums, 0));
    }
}
