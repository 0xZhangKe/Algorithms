package com.zhangke.java.graph;

import com.zhangke.java.graph.adt.DGraph;
import com.zhangke.java.graph.adt.Edge;
import com.zhangke.java.graph.adt.ListDGraph;
import com.zhangke.java.graph.adt.Vertex;

import java.util.*;

/**
 * 无权有向有圈最短路径
 * <p>
 * Created by ZhangKe on 2019/3/31.
 */
public class NoWeightShortestPath {

    public static <T> void find(DGraph<T> graph, Vertex<T> s) {
        //创建初始配置表
        Map<Vertex<T>, TableEntity<Vertex<T>>> table = TableEntity.getTable(graph, s);
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            Vertex<T> v = queue.poll();
            TableEntity<Vertex<T>> itemTable = table.get(v);
            itemTable.know = true;
            if (v.getEdgeList() != null) {
                for (Edge<Vertex<T>> edge : v.getEdgeList()) {
                    if (edge.getDest() != null) {
                        TableEntity<Vertex<T>> destTable = table.get(edge.getDest());
                        if (destTable.dist == TableEntity.INFINITY) {
                            destTable.dist = itemTable.dist + 1;
                            destTable.path = v;
                            queue.offer(edge.getDest());
                        }
                    }
                }
            }
        }
        TableEntity.printTable(table);
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

        Edge<Vertex<String>> v1v2 = new Edge<>(v1, v2);
        Edge<Vertex<String>> v1v4 = new Edge<>(v1, v4);

        Edge<Vertex<String>> v2v4 = new Edge<>(v2, v4);
        Edge<Vertex<String>> v2v5 = new Edge<>(v2, v5);

        Edge<Vertex<String>> v4v3 = new Edge<>(v4, v3);
        Edge<Vertex<String>> v4v5 = new Edge<>(v4, v5);
        Edge<Vertex<String>> v4v6 = new Edge<>(v4, v6);
        Edge<Vertex<String>> v4v7 = new Edge<>(v4, v7);

        Edge<Vertex<String>> v3v1 = new Edge<>(v3, v1);
        Edge<Vertex<String>> v3v6 = new Edge<>(v3, v6);

        Edge<Vertex<String>> v7v6 = new Edge<>(v7, v6);

        Edge<Vertex<String>> v5v7 = new Edge<>(v5, v7);

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

        find(graph, v3);
    }
}
