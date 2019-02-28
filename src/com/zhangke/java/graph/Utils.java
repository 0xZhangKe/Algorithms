package com.zhangke.java.graph;

import com.zhangke.java.graph.tree.BinaryTreeNode;

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
}