package com.zhangke.java.sort;

import java.util.Stack;

public class QuickSort implements Sortable {

    @Override
    public void sort(int[] arr) {
        doSortUseRecursion(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序递归版
     */
    private void doSortUseRecursion(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            doSortUseRecursion(arr, low, pivot - 1);                   //递归排序左子数组
            doSortUseRecursion(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    /**
     * 快速排序循环版
     */
    private void sortUseLoop(int[] array) {
        if (array == null || array.length == 1) return;
        //存放开始与结束索引
        Stack<Integer> s = new Stack<Integer>();
        //压栈
        s.push(0);
        s.push(array.length - 1);
        //利用循环里实现
        while (!s.empty()) {
            int right = s.pop();
            int left = s.pop();
            //如果最大索引小于等于左边索引，说明结束了
            if (right <= left) continue;

            int i = partition(array, left, right);
            if (left < i - 1) {
                s.push(left);
                s.push(i - 1);
            }
            if (i + 1 < right) {
                s.push(i + 1);
                s.push(right);
            }
        }
    }

    /**
     * 从两边向内将数组按照 pivot 分割成两部分，例子
     * 原数组：{6, 10, 1, 4, 2, 9, 8, 19, 3, 7}  low:0, high:9
     * {3, 10, 1, 4, 2, 9, 8, 19, 3, 7}  low:0, high:8
     * {3, 10, 1, 4, 2, 9, 8, 19, 10, 7}  low:1, high:8
     * 经过上面的一次大循环，1-8之外的数据已经按照 pivot 分割好了，下面进行第二次大循环
     * {3, 2, 1, 4, 2, 9, 8, 19, 10, 7}  low:1, high:4
     * {3, 2, 1, 4, 2, 9, 8, 19, 10, 7}  low:4, high:4
     * 结束循环
     * {3, 2, 1, 4, 6, 9, 8, 19, 10, 7}  low:4, high:4
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
}
