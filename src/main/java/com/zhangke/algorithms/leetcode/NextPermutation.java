package com.zhangke.algorithms.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 * Created by ZhangKe on 2019/12/5.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 0) return;
        int len = nums.length;
        int right = len - 1;
        int left = -1;
        int end = right;
        int start = 0;
        while (end > 0) {
            start = end - 1;
            while (start >= 0 && nums[start] >= nums[end]) start--;
            if (start > left) {
                left = start;
                right = end;
            }
            end--;
        }
        if (left >= 0) {
            //将 right 值放入 left，left 之后的值升序排列
            int rightValue = nums[right], position = right;
            while (position >= left + 1 && position <= right) {
                nums[position] = nums[position - 1];
                position--;
            }
            sortNums(nums, left + 1, nums.length);
            nums[left] = rightValue;
        } else {
            //返回升序排列
            sortNums(nums, 0, nums.length);
        }
    }

    private void sortNums(int[] nums, int start, int end) {
        List<Integer> sortList = new ArrayList<>(end - start);
        for (int i = start; i < end; i++) {
            sortList.add(nums[i]);
        }
        sortList.sort((o1, o2) -> o2 - o1);
        for (int i = start; i < end; i++) {
            nums[i] = sortList.get(end - i - 1);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2,0,2,3,2,0};
//        int[] nums = {9,5,3,2,1};
        int[] nums = {1, 3, 2};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        Util.printIntArray(nums);
    }
}
