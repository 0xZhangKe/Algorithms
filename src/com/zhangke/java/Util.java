package com.zhangke.java;

public class Util {

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int item : array) {
            System.out.print(item + ",");
        }
        System.out.print("]");
    }
}
