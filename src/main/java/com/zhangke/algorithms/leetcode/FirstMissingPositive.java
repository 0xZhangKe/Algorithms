package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.Assert;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数:
 * https://leetcode-cn.com/problems/first-missing-positive/
 * Created by ZhangKe on 2020/4/27.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int left = 0;
        if (nums.length > 1) {
            Arrays.sort(nums);
            int right = nums.length - 1;
            int pivot = -1;
            while (left < right) {
                int oldPivot = pivot;
                pivot = left + (right - left) / 2;
                if (oldPivot == pivot) {
                    break;
                }
                int pivotValue = nums[pivot];
                if (pivotValue > 0) {
                    if (pivot > 0 && nums[pivot - 1] < 0) {
                        left = pivot;
                        break;
                    } else {
                        right = pivot;
                    }
                } else {
                    if (pivot < nums.length - 1 && nums[pivot + 1] > 0) {
                        left = pivot + 1;
                        break;
                    } else {
                        left = pivot;
                    }
                }
            }
        }
        int result = 0;
        int end = nums.length - left;
        for (int i = 0; i < end; i++) {
            if (nums[left + i] != (i + 1)) {
                result = i + 1;
                break;
            }
            while (left < nums.length - i - 1 && nums[left + i] == nums[left + i + 1]) {
                left++;
                end--;
            }
        }
        if (result == 0) {
            result = nums[nums.length - 1] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        FirstMissingPositive fp = new FirstMissingPositive();
        Assert.assertEquals(2, fp.firstMissingPositive(new int[]{3, 4, -1, 1}));
        Assert.assertEquals(1, fp.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        Assert.assertEquals(2, fp.firstMissingPositive(new int[]{0, 1}));
        Assert.assertEquals(1, fp.firstMissingPositive(new int[]{-1, -2}));
        Assert.assertEquals(2, fp.firstMissingPositive(new int[]{1, 0}));
        Assert.assertEquals(3, fp.firstMissingPositive(new int[]{0, 2, 2, 1, 1}));
        Assert.assertEquals(2, fp.firstMissingPositive(new int[]{1, 1}));
        Assert.assertEquals(1, fp.firstMissingPositive(new int[]{2, 2}));
        Assert.assertEquals(1, fp.firstMissingPositive(new int[]{1000, -1}));
        Assert.assertEquals(2, fp.firstMissingPositive(new int[]{-10, -3, -100, -1000, -239, 1}));
        Assert.assertEquals(5, fp.firstMissingPositive(new int[]{1, 2, 2, 1, 3, 1, 0, 4, 0}));
        Assert.assertEquals(2, fp.firstMissingPositive(new int[]{4, 29, 53, 19, -8, 60, 59, -3, 8, 9, 53, 51, 14, -7, 53, 4, 54, 19, -6, 62, 59, 26, 32, -3, 31, 1, 57, 32, 67, 61, 24, 3, 50, 37, 60, 53, 29, 52, 10, -3, 21, -5, 59, -5, 26, 44, 9, 13, 23, 42, 35, 42, 28, 0, 0, -9, 39, 17, 33, 38, 38, 17, 1, 20, 65, 21, 33, 54}));
    }
}
