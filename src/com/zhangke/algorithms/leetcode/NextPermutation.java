package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 * Created by ZhangKe on 2019/12/5.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 0) return;
        List<Integer> numList = new ArrayList<>();
        getAllNum(nums, new ArrayList<>(), new ArrayList<>(), numList);
        int originalValue = numList.get(0);
        Collections.sort(numList);
        Integer target = null;
        for (int item : numList) {
            if (item > originalValue) {
                target = item;
                break;
            }
        }
        if (target == null) {
            target = numList.get(0);
        }
        int anchor = 10;
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum = (target - sum) % anchor;
            nums[i] = sum / (anchor / 10);
            anchor = anchor * 10;
        }
    }

    private void getAllNum(int[] data, List<Integer> recordList, List<Integer> positionList, List<Integer> list) {
        if (recordList.size() == data.length) {
            StringBuilder builder = new StringBuilder();
            for (int item : recordList) {
                builder.append(item);
            }
            list.add(Integer.valueOf(builder.toString()));
        } else {
            for (int i = 0; i < data.length; i++) {
                if (!positionList.contains(i)) {
                    positionList.add(i);
                    recordList.add(data[i]);
                    getAllNum(data, recordList, positionList, list);
                    positionList.remove(Integer.valueOf(i));
                    if (!recordList.isEmpty()) {
                        recordList.remove(recordList.size() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,1,2,0,4,1,2};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        Util.printArray(nums);
    }
}
