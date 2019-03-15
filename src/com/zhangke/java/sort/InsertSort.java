package com.zhangke.java.sort;

/**
 * 插入排序
 */
public class InsertSort implements Sortable{

    @Override
    public void sort(int[] data) {
        int tmp;
        int j;
        for (int p = 1; p < data.length; p++) {
            tmp = data[p];
            for (j = p; j > 0 && data[j - 1] > tmp; j--) {
                data[j] = data[j - 1];
            }
            data[j] = tmp;
        }
    }
}
