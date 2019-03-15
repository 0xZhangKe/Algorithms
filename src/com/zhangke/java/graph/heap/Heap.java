package com.zhangke.java.graph.heap;

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
