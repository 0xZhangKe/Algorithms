package com.zhangke.algorithms.leetcode;

import java.util.Arrays;

/**
 * 33. 搜索旋转排序数组:
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * Created by ZhangKe on 2020/3/12.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int result = -1;
        int len = nums.length;
        if (nums.length == 0) return -1;
        if (target == nums[0]) {
            return 0;
        }
        if (target == nums[len - 1]) {
            return len - 1;
        }
        int pivot = len / 2;
        int leftEdge = 0;
        int rightEdge = len - 1;
        int rightMax = nums[len - 1];
        while (pivot >= 0 && pivot < len) {
            int rightValue = pivot > 0 ? nums[pivot] - nums[pivot - 1] : 0;
            int leftValue = pivot < len - 1 ? nums[pivot + 1] - nums[pivot] : 0;
            if (rightValue > 0 && leftValue < 0) {
                break;
            } else if (rightValue > 0 && leftValue > 0) {
                if (nums[pivot] < rightMax) {
                    rightEdge = pivot;
                    pivot = leftEdge + (pivot - leftEdge) / 2;
                } else {
                    leftEdge = pivot;
                    pivot = pivot + (rightEdge - pivot) / 2;
                }
            } else if (rightValue < 0 && leftValue > 0) {
                pivot--;
                break;
            } else {
                break;
            }
        }
        boolean targetInRight = target <= rightMax;
        int left = targetInRight ? pivot + 1 : 0;
        int right = targetInRight ? len : pivot + 1;
        result = Arrays.binarySearch(nums, left, right, target);
        result = result < 0 ? -1 : result;
        return result;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray t = new SearchInRotatedSortedArray();
//        int[] array = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 0, 2, 3, 4, 5};
        int[] array = new int[]{1, 3};
        System.out.println(t.search(array, 3));
    }
}
