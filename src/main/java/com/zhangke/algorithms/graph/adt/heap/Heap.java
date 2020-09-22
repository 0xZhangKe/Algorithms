package com.zhangke.algorithms.graph.adt.heap;

/**
 * 堆
 */
public interface Heap<V extends Comparable> {

    boolean insert(V value);
    V deleteMin();
    V findMin();
    boolean isEmpty();
    boolean isFull();
}
