package com.zhangke.algorithms.sort;

/**
 * 希尔排序
 * <p>
 * Created by ZhangKe on 2019/3/17.
 */
public class ShellSort implements Sortable {

    @Override
    public void sort(int[] array) {
        int number = array.length / 2;
        int i;
        int j;
        int temp;
        while (number >= 1) {
            for (i = number; i < array.length; i++) {
                temp = array[i];
                j = i - number;
                while (j >= 0 && array[j] > temp) {
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j + number] = temp;
            }
            number = number / 2;
        }
    }
}
