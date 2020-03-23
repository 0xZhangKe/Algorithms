package com.zhangke.algorithms.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置:
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Created by ZhangKe on 2020/3/23.
 */
public class FindFLEleInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int pivot = len / 2;
        int tmp;
        int start = -1;
        int end = -1;
        int leftEdge = 0;
        int rightEdge = len;
        int lastPivot = -1;
        while (pivot >= 0 && pivot < len) {
            if (lastPivot == pivot) break;
            lastPivot = pivot;
            tmp = nums[pivot] - target;
            if (tmp == 0) {
                start = pivot;
                end = pivot;
                while (start > 0 && target - nums[start - 1] == 0) start--;
                while (end < len - 1 && target - nums[end + 1] == 0) end++;
                break;
            } else if (tmp > 0) {
                rightEdge = pivot;
                pivot = leftEdge + (pivot - leftEdge) / 2;
            } else {
                leftEdge = pivot;
                pivot += (rightEdge - pivot) / 2;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        FindFLEleInSortedArray obj = new FindFLEleInSortedArray();
        int[] nums = new int[]{1};
        Util.printArray(obj.searchRange(nums, 1));
    }
}
