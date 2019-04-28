package com.zhangke.java.graph;

import com.zhangke.java.graph.adt.DGraph;
import com.zhangke.java.graph.adt.Vertex;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于寻找最短路径的辅助配置表
 * <p>
 * Created by ZhangKe on 2019/3/31.
 */
public class TableEntity<T> {

    static final int INFINITY = Integer.MAX_VALUE;

    boolean know = false;

    int dist = INFINITY;

    T path = null;

    static <T> Map<Vertex<T>, TableEntity<Vertex<T>>> getTable(DGraph<T> graph, Vertex<T> vertex) {
        Map<Vertex<T>, TableEntity<Vertex<T>>> table = new HashMap<>();
        for (int i = 0; i < graph.size(); i++) {
            Vertex<T> v = graph.get(i);
            TableEntity<Vertex<T>> entity = new TableEntity<>();
            if (v.equals(vertex)) {
                entity.dist = 0;
            }
            table.put(v, entity);
        }
        return table;
    }

    static <T> void printTable(Map<Vertex<T>, TableEntity<Vertex<T>>> table) {
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
}
