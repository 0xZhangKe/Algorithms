package com.zhangke.java.graph;

import com.zhangke.java.graph.adt.DGraph;
import com.zhangke.java.graph.adt.Edge;
import com.zhangke.java.graph.adt.ListDGraph;
import com.zhangke.java.graph.adt.Vertex;

import java.util.*;

/**
 * 无权最短路径
 * <p>
 * Created by ZhangKe on 2019/3/31.
 */
public class NoWeightShortestPath {

    private static final int INFINITY = Integer.MAX_VALUE;

    public static <T> void find(DGraph<T> graph, Vertex<T> s) {
        Map<Vertex<T>, TableEntity<Vertex<T>>> table = new HashMap<>();
        for (int i = 0; i < graph.size(); i++) {
            Vertex<T> v = graph.get(i);
            TableEntity<Vertex<T>> entity = new TableEntity<>();
            if (v.equals(s)) {
                entity.dist = 0;
                table.put(graph.get(i), entity);
            } else {
                table.put(graph.get(i), entity);
            }
        }
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
                        if (destTable.dist == INFINITY) {
                            destTable.dist = itemTable.dist + 1;
                            destTable.path = v;
                            queue.offer(edge.getDest());
                        }
                    }
                }
            }
        }

        String divider = "        ";
        System.out.print(String.format("v%sKnown%sDv%sPv", divider, divider, divider));
        System.out.println();
        for (Vertex<T> key : table.keySet()) {
            TableEntity<Vertex<T>> itemTable = table.get(key);
            System.out.print(key.getValue() +
                    divider +
                    itemTable.know +
                    divider +
                    itemTable.dist +
                    divider +
                    (itemTable.path == null ? "null" : itemTable.path.getValue()));
            System.out.println();
        }
    }

    private static class TableEntity<T> {

        private boolean know = false;

        private int dist = INFINITY;

        private T path = null;
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
