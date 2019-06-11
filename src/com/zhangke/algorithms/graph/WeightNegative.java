package com.zhangke.algorithms.graph;

import com.zhangke.algorithms.graph.adt.DGraph;
import com.zhangke.algorithms.graph.adt.Edge;
import com.zhangke.algorithms.graph.adt.ListDGraph;
import com.zhangke.algorithms.graph.adt.Vertex;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * 有权有向有圈且具有负边值的最短路径
 * <p>
 * Created by ZhangKe on 2019/3/31.
 */
public class WeightNegative {

    private static <T> void find(DGraph<T> graph, Vertex<T> vertex) {
        Map<Vertex<T>, TableEntity<Vertex<T>>> table = TableEntity.getTable(graph, vertex);
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        queue.offer(vertex);
        while (!queue.isEmpty()) {
            Vertex<T> itemVertex = queue.poll();
            TableEntity<Vertex<T>> itemTable = table.get(itemVertex);
            itemTable.know = true;
            if (itemVertex.getEdgeList() != null) {
                for (Edge<Vertex<T>> edge : itemVertex.getEdgeList()) {
                    if (edge.getDest() != null) {
                        TableEntity<Vertex<T>> destTable = table.get(edge.getDest());
                        if (itemTable.dist + edge.getWeight() < destTable.dist) {
                            destTable.dist = itemTable.dist + edge.getWeight();
                            destTable.path = itemVertex;
                            if (!queue.contains(edge.getDest())) {
                                queue.offer(edge.getDest());
                            }
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

        Edge<Vertex<String>> v1v2 = new Edge<>(v1, v2, 2);
        Edge<Vertex<String>> v1v4 = new Edge<>(v1, v4, 1);

        Edge<Vertex<String>> v2v4 = new Edge<>(v2, v4, 3);
        Edge<Vertex<String>> v2v5 = new Edge<>(v2, v5, -10);

        Edge<Vertex<String>> v4v3 = new Edge<>(v4, v3, 2);
        Edge<Vertex<String>> v4v5 = new Edge<>(v4, v5, 2);
        Edge<Vertex<String>> v4v6 = new Edge<>(v4, v6, 8);
        Edge<Vertex<String>> v4v7 = new Edge<>(v4, v7, 4);

        Edge<Vertex<String>> v3v1 = new Edge<>(v3, v1, 4);
        Edge<Vertex<String>> v3v6 = new Edge<>(v3, v6, 5);

        Edge<Vertex<String>> v7v6 = new Edge<>(v7, v6, 1);

        Edge<Vertex<String>> v5v7 = new Edge<>(v5, v7, 6);

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

        find(graph, v1);
    }

}
