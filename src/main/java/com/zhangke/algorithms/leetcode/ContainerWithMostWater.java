package com.zhangke.algorithms.leetcode;

/**
 * 盛水最多的容器
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater water = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(water.maxArea(height));
    }

    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        int area;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                area = (j - i) * Math.min(height[j], height[i]);
                max = area > max ? area : max;
            }
        }
        return max;
    }
}
