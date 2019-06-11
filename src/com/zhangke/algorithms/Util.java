package com.zhangke.algorithms;

public class Util {

    public static void printArray(int[] array) {
        if(array == null){
            System.out.println("array is null!");
            return;
        }
        System.out.print("[");
        int item;
        for (int i = 0; i < array.length; i++) {
            item = array[i];
            if (i < array.length - 1) {
                System.out.print(item + ",");
            } else {
                System.out.print(item);
            }
        }
        System.out.print("]");
    }
}
