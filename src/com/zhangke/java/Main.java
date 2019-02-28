package com.zhangke.java;

public class Main {

    public static void main(String[] args) {
//        int size = 50000;
//        int[] array = new int[size];
//        for (int i = array.length - 1; i >= 0; i--) {
//            array[i] = i;
//        }
        int[] array = {6, 10, 1, 4, 2, 9, 8, 19, 3, 7,
                11, 56, 43, 221, 78, 45, 67, 34, 456, 33, 33, 9, 8};
        long start = System.currentTimeMillis();
//        MergeSort.sort(array);
        QuickSort.sortUseLoop(array);
        System.out.println("\nspend:" + (System.currentTimeMillis() - start) + "ms");
        Util.printArray(array);
    }

}
