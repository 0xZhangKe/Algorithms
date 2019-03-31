package com.zhangke.java.graph;

import com.zhangke.java.graph.adt.DGraph;
import com.zhangke.java.graph.adt.Edge;
import com.zhangke.java.graph.adt.ListDGraph;
import com.zhangke.java.graph.adt.Vertex;

import java.util.Map;

/**
 * 有权有圈最短路径-Dijkstra 算法
 * <p>
 * Created by ZhangKe on 2019/3/31.
 */
public class Dijkstra {

    /**
     * 1.获取未标志过的顶点列表中值最小的顶点（因为默认都是 MAX_VALUE ，所以只可能邻接节点，本质上是寻找邻接节点中的最小值）
     * 2.遍历该顶点的邻接点，如果邻接点未标记，且值小于当前路径权重值，则用当前路径权重值更新
     * 3.重复步骤1/2
     */
    private static <T> void find(DGraph<T> graph, Vertex<T> vertex) {
        Map<Vertex<T>, TableEntity<Vertex<T>>> table = TableEntity.getTable(graph, vertex);
        for (int i = 1; i < graph.size(); i++) {
            Vertex<T> minVertex = findUnknownMin(table);
            if (minVertex == null) {
                break;
            }
            TableEntity<Vertex<T>> minTable = table.get(minVertex);
            int minDist = minTable.dist;
            minTable.know = true;

            if (minVertex.getEdgeList() != null) {
                for (Edge<Vertex<T>> edge : minVertex.getEdgeList()) {
                    if (edge.getDest() != null) {
                        TableEntity<Vertex<T>> edgeTable = table.get(edge.getDest());
                        if (!edgeTable.know &&
                                (minDist + edge.getWeight() < edgeTable.dist)) {
                            edgeTable.dist = minDist + edge.getWeight();
                            edgeTable.path = minVertex;
                        }
                    }
                }
            }
        }
        TableEntity.printTable(table);
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
