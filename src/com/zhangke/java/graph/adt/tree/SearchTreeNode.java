package com.zhangke.java.graph.adt.tree;

import com.zhangke.java.graph.Utils;

/**
 * 二叉查找树
 */
public class SearchTreeNode<V> extends BinaryTreeNode<V> {

    public SearchTreeNode(V v) {
        super(v);
    }

    public SearchTreeNode(V v, BinaryTreeNode<V> left, BinaryTreeNode<V> right) {
        super(v, left, right);
    }

    public static BinaryTreeNode<Integer> find(BinaryTreeNode<Integer> tree, int src) {
        if (src < tree.getV()) {
            return find(tree.getLeft(), src);
        } else if (src > tree.getV()) {
            return find(tree.getRight(), src);
        } else {
            return tree;
        }
    }

    public static BinaryTreeNode<Integer> findMin(BinaryTreeNode<Integer> tree) {
        if (tree.getLeft() != null) {
            return findMin(tree.getLeft());
        } else {
            return tree;
        }
    }

    public static BinaryTreeNode<Integer> findMax(BinaryTreeNode<Integer> tree) {
        if (tree != null) {
            BinaryTreeNode<Integer> t = tree;
            while (t.getRight() != null) {
                t = t.getRight();
            }
            return t;
        } else {
            return null;
        }
    }

    public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> tree, int number) {
        int v = tree.getV();
        if (number < v) {
            if (tree.getLeft() != null) {
                return insert(tree.getLeft(), number);
            } else {
                BinaryTreeNode<Integer> left = new BinaryTreeNode<>(number);
                tree.setLeft(left);
                return left;
            }
        } else if (number > v) {
            if (tree.getRight() != null) {
                return insert(tree.getRight(), number);
            } else {
                BinaryTreeNode<Integer> right = new BinaryTreeNode<>(number);
                right.setParent(tree);
                tree.setRight(right);
                return right;
            }
        } else {
            return tree;
        }
    }

    public static void delete(BinaryTreeNode<Integer> tree, int target) {
        if (tree == null) return;
        int thisTreeNumber = tree.getV();
        if (target < thisTreeNumber) {
            delete(tree.getLeft(), target);
        } else if (target > thisTreeNumber) {
            delete(tree.getRight(), target);
        } else {
            if (tree.getRight() != null && tree.getLeft() != null) {
                //有两个子节点
                BinaryTreeNode<Integer> min = findMin(tree.getRight());
                tree.setV(min.getV());
                delete(tree.getRight(), min.getV());
            } else {
                if (tree.getRight() == null && tree.getLeft() == null) {
                    //叶子节点
                    if (tree.getParent() != null) {
                        if (tree.getParent().getLeft() != null
                                && tree.getParent().getLeft().getV() == target) {
                            tree.getParent().setLeft(null);
                        } else {
                            tree.getParent().setRight(null);
                        }
                    }
                } else {
                    //左边或右边有节点
                    BinaryTreeNode<Integer> sun;
                    if (tree.getLeft() != null) {
                        sun = tree.getLeft();
                    } else {
                        sun = tree.getRight();
                    }
                    if (tree.getParent().getLeft() == tree) {
                        tree.getParent().setLeft(sun);
                    } else {
                        tree.getParent().setRight(sun);
                    }
                }
            }
        }
    }

    public static int height(BinaryTreeNode<?> tree) {
        if (tree == null) {
            return -1;
        } else {
            return 1 + Math.max(height(tree.getLeft()), height(tree.getRight()));
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(6);
        {
            BinaryTreeNode<Integer> tree2 = new BinaryTreeNode<>(2);
            {
                BinaryTreeNode<Integer> tree1 = new BinaryTreeNode<>(1);
                BinaryTreeNode<Integer> tree4 = new BinaryTreeNode<>(4);
                {
                    BinaryTreeNode<Integer> tree3 = new BinaryTreeNode<>(3);
                    tree3.setParent(tree4);
                    tree4.setLeft(tree3);
                }
                tree1.setParent(tree2);
                tree4.setParent(tree2);
                tree2.setLeft(tree1);
                tree2.setRight(tree4);
            }
            BinaryTreeNode<Integer> tree8 = new BinaryTreeNode<>(8);
            tree8.setParent(root);
            tree2.setParent(root);
            root.setLeft(tree2);
            root.setRight(tree8);
        }
        Utils.printTree(root);

        System.out.println("find min:" + findMin(root).getV());
        System.out.println("find max:" + findMax(root).getV());

        insert(root, 5);
        System.out.println("insert 5");

        Utils.printTree(root);

        System.out.println("delete 2");
        delete(root, 2);
        Utils.printTree(root);

        System.out.println("height:" + height(root));
    }


}
