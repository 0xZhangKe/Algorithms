package com.zhangke.algorithms.graph.adt;

import com.zhangke.algorithms.graph.Utils;

import java.util.LinkedList;
import java.util.List;

/**
 * 顶点对象
 * <p>
 * Created by ZhangKe on 2019/3/28.
 */
public class Vertex<V> {
    /**
     * 此顶点
     */
    private V value;
    /**
     * 以此顶点为起点的边的集合，是一个列表，列表的每一项是一条边
     */
    private List<Edge<Vertex<V>>> mEdgeList;

    /**
     * 构造一个新的顶点对象
     */
    public Vertex(V v) {
        this.value = v;
        this.mEdgeList = new LinkedList<>();
        Utils.log("Vertex construct : %s", v);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * 将一条边添加到边集合中
     */
    public void addEdge(Edge<Vertex<V>> e) {
        Utils.log("add edge : %s", e);
        if (getEdge(e.getDest()) == null) {
            mEdgeList.add(e);
        } else {
            Utils.log("edge exist : %s", e);
        }
    }

    /**
     * 读取某条边
     */
    public Edge<Vertex<V>> getEdge(Vertex<V> dest) {
        Edge<Vertex<V>> ret = null;
        if (dest != null) {
            for (Edge<Vertex<V>> edge : mEdgeList) {
                if (edge.getDest() != null &&
                        dest.equals(edge.getDest())) {
                    Utils.log("get edge : %s", edge);
                    ret = edge;
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * 删除某条边
     */
    public Edge<Vertex<V>> removeEdge(Vertex<V> dest) {
        Edge<Vertex<V>> ret = null;
        if (dest != null) {
            for (Edge<Vertex<V>> edge : mEdgeList) {
                if (edge.getDest() != null &&
                        dest.equals(edge.getDest())) {
                    Utils.log("remove edge : %s", edge);
                    ret = edge;
                    mEdgeList.remove(edge);
                    break;
                }
            }
        }
        return ret;
    }

    public V getValue() {
        return value;
    }

    public List<Edge<Vertex<V>>> getEdgeList() {
        return mEdgeList;
    }
}
