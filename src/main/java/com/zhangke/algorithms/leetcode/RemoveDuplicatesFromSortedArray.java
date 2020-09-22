package com.zhangke.algorithms.leetcode;

/**
 * 26. 删除排序数组中的重复项:
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * Created by ZhangKe on 2019/11/13.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int originPosition = 1;
        int newPosition = 0;
        int[] newNums = new int[len];
        newNums[0] = nums[0];
        while (originPosition < len) {
            if (nums[originPosition] > newNums[newPosition]) {
                newNums[++newPosition] = nums[originPosition];
            }
            originPosition++;
        }
        int newLen = newPosition + 1;
        System.arraycopy(newNums, 0, nums, 0, newLen);
        return newLen;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray duplicates = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2};
        System.out.println(duplicates.removeDuplicates(nums));
    }
}
