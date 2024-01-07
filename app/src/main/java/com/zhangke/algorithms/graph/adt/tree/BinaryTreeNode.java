package com.zhangke.algorithms.graph.adt.tree;

/**
 * 二叉树
 */
public class BinaryTreeNode<V> {

    private V v;
    private BinaryTreeNode<V> left;
    private BinaryTreeNode<V> right;
    private BinaryTreeNode<V> parent;

    public BinaryTreeNode(V v) {
        this.v = v;
    }

    public BinaryTreeNode(V v, BinaryTreeNode<V> left, BinaryTreeNode<V> right) {
        this.v = v;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(V v, BinaryTreeNode<V> left, BinaryTreeNode<V> right, BinaryTreeNode<V> parent) {
        this.v = v;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public BinaryTreeNode<V> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<V> left) {
        this.left = left;
    }

    public BinaryTreeNode<V> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<V> right) {
        this.right = right;
    }

    public BinaryTreeNode<V> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<V> parent) {
        this.parent = parent;
    }
}
