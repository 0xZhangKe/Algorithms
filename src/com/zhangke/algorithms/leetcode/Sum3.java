package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 三数之和：https://leetcode-cn.com/problems/3sum/
 * Created by ZhangKe on 2019/7/19.
 */
public class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        quickSort(nums);
        int max = nums[nums.length - 1];
        int lastMax = max + nums[nums.length - 2];
        int first = 0;
        int second;
        int third;
        int tmp;
        while (first < nums.length - 2) {
            if (nums[first] > 0) {
                break;
            }
            if (0 - first > lastMax) {
                first++;
                continue;
            }
            second = first + 1;
            while (second < nums.length - 1) {
                tmp = nums[first] + nums[second];
                if (0 - tmp > max) {
                    second++;
                    continue;
                }
                if (tmp > 0) {
                    break;
                }
                third = second + 1;
                while (third < nums.length) {
                    tmp = nums[first] + nums[second] + nums[third];
                    if (tmp > 0) {
                        break;
                    }
                    if (tmp == 0) {
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[first]);
                        li.add(nums[second]);
                        li.add(nums[third]);
                        if (!list.contains(li)) {
                            list.add(li);
                        }
                        break;
                    }
                    third++;
                }
                second++;
            }
            first++;
        }
        return list;
    }

    private void quickSort(int[] array) {
        if (array == null || array.length == 1) return;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.empty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (right <= left) continue;
            int i = partition(array, left, right);
            if (left < i - 1) {
                stack.push(left);
                stack.push(i - 1);
            }
            if (i + 1 < right) {
                stack.push(i + 1);
                stack.push(right);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];
        }
        arr[high] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {0, -4, -1, -4, -2, -3, 2};
        Sum3 sum = new Sum3();
        System.out.println(sum.threeSum(nums));
    }
}
