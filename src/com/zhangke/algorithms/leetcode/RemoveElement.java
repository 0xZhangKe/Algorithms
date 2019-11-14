package com.zhangke.algorithms.leetcode;

/**
 * 27. 移除元素:
 * https://leetcode-cn.com/problems/remove-element/
 * Created by ZhangKe on 2019/11/14.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int newLen = nums.length;
        int position = nums.length - 1;
        int offset;
        while (position >= 0) {
            offset = 0;
            while (position >= 0 && nums[position] == val) {
                offset++;
                position--;
            }
            if (offset > 0) {
                for (int i = position + offset + 1; i < newLen; i++) {
                    if (i < nums.length && i - offset >= 0) {
                        nums[i - offset] = nums[i];
                    }
                }
            } else {
                position--;
            }
            newLen -= offset;
        }
        return newLen;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(new RemoveElement().removeElement(nums, 2));
    }
}
