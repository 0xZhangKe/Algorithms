package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.leetcode.utils.ArrayUtils;
import kotlin.text.StringsKt;

/**
 * 75. 颜色分类
 * <a href="https://leetcode.cn/problems/sort-colors/?favorite=2cktkvj">75. 颜色分类</a>
 *
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        assertCase1(sortColors);
    }

    private static void assertCase1(SortColors sortColors) {
        int[] array = new int[]{2, 0, 2, 1, 1, 0};
        sortColors.sortColors(array);
        ArrayUtils.INSTANCE.printArray(array);
    }

    public void sortColors(int[] nums) {
        int currentColor = 0;
        int currentIndex = 0;
        int tmp;
        while (currentIndex < nums.length - 1) {
            if (nums[currentIndex] == currentColor) {
                currentIndex++;
                continue;
            }
            if (currentColor == 2) break;
            for (int j = currentIndex + 1; j < nums.length; j++) {
                if (nums[j] == currentColor) {
                    tmp = nums[currentIndex];
                    nums[currentIndex] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
            if (nums[currentIndex] != currentColor) {
                currentColor++;
            } else {
                currentIndex++;
            }
        }
    }
}