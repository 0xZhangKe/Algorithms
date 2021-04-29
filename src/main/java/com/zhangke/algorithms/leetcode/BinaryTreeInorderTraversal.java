package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.leetcode.adt.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历:
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * Created by ZhangKe on 2021/4/17.
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> record = new ArrayList<>();
        dfs(root, record);
        return record;
    }

    private void dfs(TreeNode root, List<Integer> record){
        if(root == null) return;
        dfs(root.left, record);
        record.add(root.val);
        dfs(root.right, record);
    }

    public static void main(String[] args){
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();
        Util.printList(traversal.inorderTraversal(node1));
    }
}
