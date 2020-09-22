package com.zhangke.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序，
 * 桶为一个 List，每个元素又是一个 List，
 * 桶中的 List 使用插入排序，数据按照一定的规则计算出 index 值，
 * 并存入桶中对应的位置，这样桶自然就排好序了。
 * 然后遍历桶以及桶中的 List，将输入按照顺序取出，即
 * <p>
 * Created by ZhangKe on 2019/3/19.
 */
public class BucketSort implements Sortable {

    @Override
    public void sort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int a : arr) {
            max = max < a ? a : max;
            min = min < a ? min : a;
        }
        // 該值也可根據實際情況選擇
        int bucketNum = max / 10 - min / 10 + 1;
        List<List<Integer>> buckList = new ArrayList<>();
        // create bucket
        for (int i = 1; i <= bucketNum; i++) {
            buckList.add(new ArrayList<>());
        }
        // push into the bucket
        for (int a : arr) {
            int index = indexFor(a, min, 10);
            buckList.get(index).add(a);
        }
        ArrayList<Integer> bucket;
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            bucket = (ArrayList<Integer>) buckList.get(i);
            insertSort(bucket);
            for (int k : bucket) {
                arr[index++] = k;
            }
        }
    }

    private int indexFor(int a, int min, int step) {
        return (a - min) / step;
    }

    // 把桶內元素插入排序
    private void insertSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int temp = bucket.get(i);
            int j = i - 1;
            for (; j >= 0 && bucket.get(j) > temp; j--) {
                bucket.set(j + 1, bucket.get(j));
            }
            bucket.set(j + 1, temp);
        }
    }
}
