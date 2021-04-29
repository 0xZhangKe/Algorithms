package com.zhangke.algorithms.leetcode;


import com.zhangke.algorithms.leetcode.adt.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历:
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * Created by ZhangKe on 2021/4/17.
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> record = new ArrayList<>();
        dfs(root, record);
        return record;
    }

    private void dfs(TreeNode root, List<Integer> record){
        if(root == null) return;
        record.add(root.val);
        dfs(root.left, record);
        dfs(root.right, record);
    }

    public static void main(String[] args){
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, node2, null);
        BinaryTreePreorderTraversal traversal = new BinaryTreePreorderTraversal();
        Util.printList(traversal.preorderTraversal(node1));
    }
}
