package com.zhangke.algorithms;

import java.util.List;
import java.lang.Integer;

public class DC {

    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long start = System.currentTimeMillis();
        int[][] a = getMultipTable(array);
        for (int[] item : a) {
            Util.printArray(item);
            System.out.print("\n");
        }
        System.out.println("\nspend:" + (System.currentTimeMillis() - start) + "ms");
    }

    public static <T> int getListSize(List<T> list, int position) {
        if (position >= list.size()) {
            return position;
        } else {
            return getListSize(list, ++position);
        }
    }

    public static int findMaxInt(List<Integer> list, int position, int max) {
        if (position >= list.size()) {
            return max;
        } else {
            max = list.get(position) > max ? list.get(position) : max;
            return findMaxInt(list, ++position, max);
        }
    }

    public static int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        } else {
            int[] smallArray = new int[array.length - 1];
            for (int i = 1; i < array.length; i++) {
                smallArray[i - 1] = array[i];
            }
            return array[0] + sum(smallArray);
        }
    }

    public static int[][] getMultipTable(int[] array) {
        int[][] table = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            table[i] = getMultipArray(array[i], array);
        }
        return table;
    }

    private static int[] getMultipArray(int a, int[] array) {
        int[] multiedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            multiedArray[i] = a * array[i];
        }
        return multiedArray;
    }
}