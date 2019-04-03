package com.zhangke.java.graph;

import com.zhangke.java.graph.adt.DGraph;
import com.zhangke.java.graph.adt.Edge;
import com.zhangke.java.graph.adt.ListDGraph;
import com.zhangke.java.graph.adt.Vertex;

import java.util.Map;

/**
 * 最小生成树-prim 算法
 * <p>
 * Created by ZhangKe on 2019/4/2.
 */
public class Prim {

    /**
     * 类似 {@link Dijkstra} 算法。
     * 每次循环都选取 Table 中值最小的边。
     */
    private static <T> void find(DGraph<T> graph, Vertex<T> vertex) {
        Map<Vertex<T>, TableEntity<Vertex<T>>> table = TableEntity.getTable(graph, vertex);
        DGraph<T> primGraph = new ListDGraph<>();
        for (int i = 0; i < graph.size(); i++) {
            Vertex<T> minVertex = findUnknownMin(table);
            if (minVertex == null) {
                break;
            }
            TableEntity<Vertex<T>> minTable = table.get(minVertex);
            minTable.know = true;
            primGraph.add(new Vertex<>(minVertex.getValue()));
            if (minTable.path != null) {
                T thisValue = minVertex.getValue();
                T pathValue = minTable.path.getValue();
                primGraph.add(new Edge<>(new Vertex<>(thisValue), new Vertex<>(pathValue)));
                primGraph.add(new Edge<>(new Vertex<>(pathValue), new Vertex<>(thisValue)));
            }
            if (minVertex.getEdgeList() != null) {
                for (Edge<Vertex<T>> edge : minVertex.getEdgeList()) {
                    if (edge.getDest() != null) {
                        TableEntity<Vertex<T>> edgeTable = table.get(edge.getDest());
                        if (!edgeTable.know && edge.getWeight() < edgeTable.dist) {
                            edgeTable.dist = edge.getWeight();
                            edgeTable.path = minVertex;
                        }
                    }
                }
            }
        }
        System.out.println();
        Utils.printGraph(primGraph);
    }

    /**
     * 从为知表中读取一个 dist 最小的定点
     */
    private static <T> Vertex<T> findUnknownMin(Map<Vertex<T>, TableEntity<Vertex<T>>> table) {
        int min = TableEntity.INFINITY;
        Vertex<T> vertex = null;
        for (Vertex<T> key : table.keySet()) {
            TableEntity<Vertex<T>> item = table.get(key);
            if (!item.know && min >= item.dist) {
                min = item.dist;
                vertex = key;
            }
        }
        return vertex;
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

        find(graph, v1);
    }
}
