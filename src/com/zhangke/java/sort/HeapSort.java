package com.zhangke.java.sort;

/**
 * 堆排序
 * <p>
 * Created by ZhangKe on 2019/3/18.
 */
public class HeapSort implements Sortable {

    @Override
    public void sort(int[] data) {
        sort(data, data.length);
    }

    private void sort(int[] data, int N) {
        int i;
        for (i = N / 2; i >= 0; i--) {
            percDown(data, i, N);
        }
        for (i = N - 1; i > 0; i--) {
            swap(data, 0, i);
            percDown(data, 0, i);
        }
    }

    private void percDown(int[] data, int i, int N) {
        int child = 0;
        int tmp;
        for (tmp = data[i]; leftChild(i) < N; i = child) {
            child = leftChild(i);
            if (child != N - 1 && data[child + 1] > data[child]) {
                child++;
            }
            if (tmp < data[child]) {
                data[i] = data[child];
            } else {
                break;
            }
        }
        data[i] = tmp;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
