package com.zhangke.java.graph.adt;

/**
 * 一条边，可以根据需要继承此类
 *
 * @param <V>
 */
public class Edge<V> implements Comparable<Edge<V>> {
    /**
     * 起点
     */
    private V src;
    /**
     * 终点
     */
    private V dest;
    /**
     * 权值
     */
    private int weight;

    /**
     * 不带权值的一条边
     */
    public Edge(V src, V dest) {
        this(src, dest, 0);
    }

    /**
     * 带权值的一条边
     */
    public Edge(V src, V dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    /**
     * 获取起点
     */
    public V getSource() {
        return this.src;
    }

    /**
     * 获取终点
     */
    public V getDest() {
        return this.dest;
    }

    /**
     * 获取权值
     */
    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge<V> o) {
        return weight - o.getWeight();
    }

    @Override
    public String toString() {
        return String.format("src : %s , dest : %s , weight : %s", src, dest, weight);
    }
}
