package com.zhangke.algorithms.sort;


import com.zhangke.algorithms.leetcode.Util;

public class SortTest {

    public static void main(String[] args) {
        Sortable sortable = new MergeSort();
        int[] array = {6, 10, 1, 4, 2, 9, 8, 19, 3, 7,
                11, 56, 43, 221, 78, 45, 67, 34, 456, 33, 33, 9, 8};
        long start = System.currentTimeMillis();
        sortable.sort(array);
        System.out.println("\nspend:" + (System.currentTimeMillis() - start) + "ms");
        Util.printIntArray(array);
    }
}
