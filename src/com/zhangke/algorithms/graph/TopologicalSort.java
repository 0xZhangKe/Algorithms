package com.zhangke.algorithms.graph;

import com.zhangke.algorithms.graph.adt.Edge;
import com.zhangke.algorithms.graph.adt.ListDGraph;
import com.zhangke.algorithms.graph.adt.Vertex;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序
 * <p>
 * Created by ZhangKe on 2019/3/27.
 */
public class TopologicalSort {

    public static <T> void sort(ListDGraph<T> graph) {
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        Queue<Vertex<T>> resultQueue = new ArrayDeque<>();
        int size = graph.size();
        int[] indegree = new int[size];//入度数组
        for (int i = 0; i < size; i++) {
            List<Edge<Vertex<T>>> edges = graph.get(i).getEdgeList();
            for (Edge<Vertex<T>> item : edges) {
                indegree[graph.get(item.getDest())]++;
            }
        }
        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                queue.offer(graph.get(i));
            }
        }
        while (!queue.isEmpty()) {
            Vertex<T> vertex = queue.poll();
            resultQueue.offer(vertex);
            List<Edge<Vertex<T>>> edges = vertex.getEdgeList();
            if (edges != null) {
                for (Edge<Vertex<T>> edge : edges) {
                    int index = graph.get(edge.getDest());
                    indegree[index]--;
                    if (indegree[index] <= 0) {
                        queue.offer(edge.getDest());
                    }
                }
            }
        }
        while (!resultQueue.isEmpty()) {
            Vertex<T> item = resultQueue.poll();
            System.out.print(item.getValue());
            if (!resultQueue.isEmpty()) {
                System.out.print(" -> ");
            }
        }
    }
}
