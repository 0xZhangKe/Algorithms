package com.zhangke.algorithms.leetcode.offer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * Created by ZhangKe on 2021/3/17.
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int xStart = 0;
        int yStart = 0;
        int xEnd = matrix[0].length - 1;
        int yEnd = matrix.length - 1;
        int x = (xEnd - yEnd) / 2;
        int y = (yEnd - yStart) / 2;
        while (xStart < xEnd || yStart < yEnd) {
            int value = matrix[x][y];
            if (value == target) return true;
            if (value < target) {
                xEnd = x;
                yEnd = y;
            }else{
                xStart = x;
                yStart = y;
            }
            int xResult = binarySearch(matrix[x], xStart, xEnd, target);
            if (xResult != -1) return true;
            int yResult = binarySearch(matrix, x, yStart, yEnd, target);
            if (yResult != -1) return true;
        }
        return false;
    }

    private int binarySearch(int[] array, int start, int end, int target) {
        int lastPivot = -1;
        while (start < end) {
            System.out.println("binarySearch[] start:" + start + " end:" + end);
            int pivot = end - start / 2 - 1;
            pivot = pivot < 0 ? 0 : pivot;
            if(pivot == lastPivot) return -1;
            lastPivot = pivot;
            int value = array[pivot];
            if (value == target) {
                return pivot;
            } else if (value < target) {
                end = pivot;
            } else {
                start = pivot;
            }
        }
        return -1;
    }

    private int binarySearch(int[][] array, int x, int start, int end, int target) {
        int lastPivot = -1;
        while (start < end) {
            System.out.println("binarySearch[][] start:" + start + " end:" + end);
            int pivot = end - start / 2 - 1;
            pivot = pivot < 0 ? 0 : pivot;
            if(pivot == lastPivot) return -1;
            lastPivot = pivot;
            int value = array[x][pivot];
            if (value == target) {
                return pivot;
            } else if (value < target) {
                end = pivot;
            } else {
                start = pivot;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        case1();
    }

    private static void case1() {
        FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
        int[][] array = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(array, 5));
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(array, 20));
    }
}
