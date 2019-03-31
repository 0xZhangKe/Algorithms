package com.zhangke.java.graph.adt.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆，二叉堆
 */
public class BinaryHeap<V extends Comparable<V>> implements Heap<V> {

    private final int capacity;
    private List<V> elements;
    private int size = 0;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        elements = new ArrayList<>(capacity);
    }

    @Override
    public boolean insert(V value) {
        if (isFull()) return false;
//        insertVal(size + 1, value);
        insertValNotRecursive(value);
        size++;
        return true;
    }

    private void insertVal(int position, V value) {
        if (position == 0) {
            if (elements.isEmpty()) {
                elements.add(value);
            } else {
                elements.set(0, value);
            }
            return;
        }
        int parentPosition = (position - 1) / 2;//父节点下标
        if (parentPosition <= 0) {
            parentPosition = 0;
        }
        if (elements.size() <= parentPosition) {
            //没有父节点
            elements.add(value);
        } else {
            int compare = value.compareTo(elements.get(parentPosition));
            if (compare <= 0) {
                //大于父节点
                //将父节点的值移动到该节点
                if (elements.size() <= position) {
                    elements.add(elements.get(parentPosition));
                } else {
                    elements.set(position, elements.get(parentPosition));
                }
                insertVal(parentPosition, value);
            } else {
                //小于等于父节点
                if (elements.size() <= position) {
                    elements.add(value);
                } else {
                    elements.set(position, value);
                }
            }
        }
    }

    /**
     * 插入，非递归版
     */
    private void insertValNotRecursive(V value) {
        int curPosition = elements.size();
        elements.add(value);
        int parentPosition = (curPosition - 1) / 2;
        V tmp = elements.get(curPosition);

        while (curPosition > 0) {
            int compare = tmp.compareTo(elements.get(parentPosition));
            if (compare >= 0) {
                //待插入值大于等于父节点
                break;
            } else {
                elements.set(curPosition, elements.get(parentPosition));
                curPosition = parentPosition;
                parentPosition = (parentPosition - 1) / 2;
            }
        }
        elements.set(curPosition, value);
    }

    @Override
    public V deleteMin() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            V element = elements.get(0);
            elements.remove(0);
            size = 0;
            return element;
        }
        int child = 1;
        V minElement, lastElement;
        minElement = elements.get(0);
        lastElement = elements.get(size - 1);
        int i = 0;
        for (i = 0; i * 2 <= size; i = child) {
            child = (i + 1) * 2 - 1;
            if (child != size &&
                    (elements.get(child + 1).compareTo(elements.get(child)) < 0)) {
                child++;
            }
            if (lastElement.compareTo(elements.get(child)) > 0) {
                elements.set(i, elements.get(child));
            } else {
                break;
            }
        }
        elements.set(i, lastElement);
        size--;
        return minElement;
    }

    @Override
    public V findMin() {
        if (isEmpty()) return null;
        return elements.get(0);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(10);
        heap.insert(68);
        heap.insert(65);
        heap.insert(26);
        heap.insert(13);
        heap.insert(21);
        heap.insert(16);
        heap.insert(24);
        heap.insert(31);
        heap.insert(19);
        heap.insert(32);

        heap.deleteMin();
    }

    private static void printTree(Heap<?> heap) {

    }
}
