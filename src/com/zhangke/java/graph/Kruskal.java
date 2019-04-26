package com.zhangke.java.graph;

import com.zhangke.java.graph.adt.DGraph;
import com.zhangke.java.graph.adt.Edge;
import com.zhangke.java.graph.adt.ListDGraph;
import com.zhangke.java.graph.adt.Vertex;
import com.zhangke.java.graph.adt.heap.BinaryHeap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.zhangke.java.graph.adt.DGraph.ITERATOR_TYPE_BFS;

/**
 * 最小生成树- Kruskal 算法
 * <p>
 * Created by ZhangKe on 2019/4/23.
 */
public class Kruskal {

    /**
     * 1.新建图G，G中拥有原图中相同的节点，但没有边
     * 2.将原图中所有的边按权值从小到大排序
     * 3.从权值最小的边开始，如果这条边连接的两个节点于图G中不在同一个连通分量中，则添加这条边到图G中
     * 4.重复3，直至图G中所有的节点都在同一个连通分量中
     */
    private static <T> DGraph<T> find(DGraph<T> graph, Vertex<T> vertex) {
        DGraph<T> newGraph = getNoEdgeGraph(graph);
        BinaryHeap<Edge<Vertex<T>>> priorityQueue = makePriorityQueue(graph);
        while (!priorityQueue.isEmpty()) {
            Edge<Vertex<T>> edge = priorityQueue.deleteMin();
            if (edge.getDest() != null
                    && edge.getSource() != null) {
                if (!connected(newGraph, edge.getDest(), edge.getSource())) {
                    newGraph.add(new Edge<>(edge.getDest(), edge.getSource()));
                    newGraph.add(new Edge<>(edge.getSource(), edge.getDest()));
                }
            }
        }
        return newGraph;
    }

    private static <T> DGraph<T> getNoEdgeGraph(DGraph<T> graph) {
        DGraph<T> newGraph = new ListDGraph<>();
        Iterator<T> iterator = graph.iterator(ITERATOR_TYPE_BFS, graph.get(0).getValue());
        while (iterator.hasNext()) {
            newGraph.add(new Vertex<>(iterator.next()));
        }
        return newGraph;
    }

    private static <T> BinaryHeap<Edge<Vertex<T>>> makePriorityQueue(DGraph<T> graph) {
        BinaryHeap<Edge<Vertex<T>>> priorityQueue = new BinaryHeap<>();
        for (int i = 0; i < graph.size(); i++) {
            Vertex<T> ve = graph.get(i);
            List<Edge<Vertex<T>>> edgeList = ve.getEdgeList();
            if (edgeList != null
                    && !edgeList.isEmpty()) {
                for (Edge<Vertex<T>> edge : edgeList) {
                    priorityQueue.insert(edge);
                }
            }
        }
        return priorityQueue;
    }

    private static <T> boolean connected(DGraph<T> graph, Vertex<T> ve1, Vertex<T> ve2) {
        Iterator<T> iterator = graph.iterator(ITERATOR_TYPE_BFS, ve1.getValue());
        while (iterator.hasNext()) {
            if (iterator.next().equals(ve2.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DGraph<String> graph = new ListDGraph<>();
        Vertex<String> v1 = new Vertex<>("1");
        Vertex<String> v2 = new Vertex<>("2");
        Vertex<String> v3 = new Vertex<>("3");
        Vertex<String> v4 = new Vertex<>("4");
        Vertex<String> v5 = new Vertex<>("5");
        Vertex<String> v6 = new Vertex<>("6");
        Vertex<String> v7 = new Vertex<>("7");

        Edge<Vertex<String>> v1v2 = new Edge<>(v1, v2, 2);
        Edge<Vertex<String>> v1v4 = new Edge<>(v1, v4, 1);

        Edge<Vertex<String>> v2v4 = new Edge<>(v2, v4, 3);
        Edge<Vertex<String>> v2v5 = new Edge<>(v2, v5, 10);

        Edge<Vertex<String>> v4v3 = new Edge<>(v4, v3, 2);
        Edge<Vertex<String>> v4v5 = new Edge<>(v4, v5, 7);
        Edge<Vertex<String>> v4v6 = new Edge<>(v4, v6, 8);
        Edge<Vertex<String>> v4v7 = new Edge<>(v4, v7, 4);

        Edge<Vertex<String>> v3v1 = new Edge<>(v3, v1, 4);
        Edge<Vertex<String>> v3v6 = new Edge<>(v3, v6, 5);

        Edge<Vertex<String>> v7v6 = new Edge<>(v7, v6, 1);

        Edge<Vertex<String>> v5v7 = new Edge<>(v5, v7, 6);


        ////////////
        Edge<Vertex<String>> v2v1 = new Edge<>(v2, v1, 2);
        Edge<Vertex<String>> v4v1 = new Edge<>(v4, v1, 1);

        Edge<Vertex<String>> v4v2 = new Edge<>(v4, v2, 3);
        Edge<Vertex<String>> v5v2 = new Edge<>(v5, v2, 10);

        Edge<Vertex<String>> v3v4 = new Edge<>(v3, v4, 2);
        Edge<Vertex<String>> v5v4 = new Edge<>(v5, v4, 7);
        Edge<Vertex<String>> v6v4 = new Edge<>(v6, v4, 8);
        Edge<Vertex<String>> v7v4 = new Edge<>(v7, v4, 4);

        Edge<Vertex<String>> v1v3 = new Edge<>(v1, v3, 4);
        Edge<Vertex<String>> v6v3 = new Edge<>(v6, v3, 5);

        Edge<Vertex<String>> v6v7 = new Edge<>(v6, v7, 1);

        Edge<Vertex<String>> v7v5 = new Edge<>(v7, v5, 6);

        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);
        graph.add(v6);
        graph.add(v7);

        graph.add(v1v2);
        graph.add(v1v4);

        graph.add(v2v4);
        graph.add(v2v5);

        graph.add(v4v3);
        graph.add(v4v5);
        graph.add(v4v6);
        graph.add(v4v7);

        graph.add(v3v1);
        graph.add(v3v6);

        graph.add(v7v6);
        graph.add(v5v7);


        ///////////////////
        graph.add(v2v1);
        graph.add(v4v1);

        graph.add(v4v2);
        graph.add(v5v2);

        graph.add(v3v4);
        graph.add(v5v4);
        graph.add(v6v4);
        graph.add(v7v4);

        graph.add(v1v3);
        graph.add(v6v3);

        graph.add(v6v7);
        graph.add(v7v5);

        DGraph<String> dGraph = find(graph, v1);
    }
}
