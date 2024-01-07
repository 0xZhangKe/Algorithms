package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.leetcode.adt.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98.验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/
 * <p>
 * 二叉搜索树特性比较明确，按照DFS遍历，输出的结果应该是递增的，依据这一特性可对二叉搜索树进行验证。
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        List<Integer> collector = new ArrayList<>();
        dfs(root, collector);
        boolean validate = true;
        int lastValue = 0;
        for (int i = 0; i < collector.size(); i++) {
            int item = collector.get(i);
            if (i == 0) {
                lastValue = item;
                continue;
            }
            if (item <= lastValue) {
                validate = false;
                break;
            }
            lastValue = item;
        }
        return validate;
    }

    public void dfs(TreeNode root, List<Integer> collector) {
        if (root == null) return;
        dfs(root.left, collector);
        collector.add(root.val);
        dfs(root.right, collector);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree target = new ValidateBinarySearchTree();
        System.out.println(target.isValidBST(buildCase1Node()));
        System.out.println(target.isValidBST(buildCase2Node()));
        System.out.println(target.isValidBST(buildCase3Node()));
        System.out.println(target.isValidBST(buildCase4Node()));
    }

    private static TreeNode buildCase1Node() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        return node2;
    }

    private static TreeNode buildCase2Node() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node5.left = node1;
        node5.right = node4;
        node4.left = node3;
        node4.right = node6;
        return node5;
    }

    private static TreeNode buildCase3Node() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node5.left = node4;
        node5.right = node6;
        node6.left = node3;
        node6.right = node7;
        return node5;
    }

    private static TreeNode buildCase4Node() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node5.left = node4;
        node5.right = node6;
        node6.left = node3;
        node6.right = node7;
        return node5;
    }
}
