package com.zhangke.algorithms.leetcode;

/**
 * 35. 搜索插入位置:
 * https://leetcode-cn.com/problems/search-insert-position/
 * Created by ZhangKe on 2020/3/23.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return 0;
        int pivot = len / 2;
        int right = len;
        int left = 0;
        int tmp;
        int lastPivot = -1;
        while (left <= right) {
            tmp = nums[pivot] - target;
            if (tmp == 0) {
                return pivot;
            } else if (tmp > 0) {
                if (lastPivot == pivot) {
                    pivot--;
                    if (pivot < 0) {
                        pivot = 0;
                    }
                    break;
                }
                lastPivot = pivot;
                right = pivot;
                pivot = left + (pivot - left) / 2;
            } else {
                if (lastPivot == pivot) {
                    pivot++;
                    break;
                }
                lastPivot = pivot;
                left = pivot;
                pivot = pivot + (right - pivot) / 2;
            }
        }
        return pivot;
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] nums = new int[]{-1};
        System.out.println(sip.searchInsert(nums, 0));
        System.out.println(sip.searchInsert(nums, 2));
    }
}
