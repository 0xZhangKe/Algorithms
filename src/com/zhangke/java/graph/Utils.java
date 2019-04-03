package com.zhangke.java.graph;

import com.zhangke.java.graph.adt.DGraph;
import com.zhangke.java.graph.adt.Edge;
import com.zhangke.java.graph.adt.Vertex;
import com.zhangke.java.graph.adt.tree.BinaryTreeNode;

/**
 * 一些工具类
 */
public class Utils {

    /**
     * 打印信息
     */
    public static void log(Object t) {
        System.out.println(t);
    }

    /**
     * 打印信息
     */
    public static void log(String format, Object... args) {
        String str = String.format(format, args);
        System.out.println(str);
    }

    public static void printTree(BinaryTreeNode<?> tree) {
        printTree(tree, 0);
    }

    public static void printTree(BinaryTreeNode<?> tree, int depth) {
        printTreeNodeWithSpace(tree, depth);
        if (tree.getLeft() != null) {
            printTree(tree.getLeft(), depth + 1);
        }
        if (tree.getRight() != null) {
            printTree(tree.getRight(), depth + 1);
        }
    }

    private static void printTreeNodeWithSpace(BinaryTreeNode d, int depth) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            space = space.append("    ");
        }
        System.out.println(String.format("%s%s", space.toString(), d.getV()));
    }

    public static <T> void printGraph(DGraph<T> graph) {
        for (int i = 0; i < graph.size(); i++) {
            Vertex<T> vertex = graph.get(i);
            System.out.print(vertex.getValue().toString());
            System.out.print(", edge:");
            if (vertex.getEdgeList() == null) {
                System.out.print("null");
            } else {
                if (vertex.getEdgeList().isEmpty()) {
                    System.out.print("empty");
                } else {
                    for (int j = 0; j < vertex.getEdgeList().size(); j++) {
                        System.out.print(vertex.getEdgeList().get(j).getDest().getValue());
                        System.out.print(", ");
                    }
                }
            }
            System.out.println();
        }
    }
}