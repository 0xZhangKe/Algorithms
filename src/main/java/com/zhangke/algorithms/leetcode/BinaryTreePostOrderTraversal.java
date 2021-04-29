package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.leetcode.adt.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历:
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * Created by ZhangKe on 2021/4/17.
 */
public class BinaryTreePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> record = new ArrayList<>();
        dfs(root, record);
        return record;
    }

    private void dfs(TreeNode root, List<Integer> record){
        if(root == null) return;
        dfs(root.left, record);
        dfs(root.right, record);
        record.add(root.val);
    }

    public static void main(String[] args){
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        BinaryTreePostOrderTraversal traversal = new BinaryTreePostOrderTraversal();
        Util.printList(traversal.postorderTraversal(node1));
    }
}
