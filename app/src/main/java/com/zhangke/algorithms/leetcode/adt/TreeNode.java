package com.zhangke.algorithms.leetcode.adt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangKe on 2021/4/17.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildNode(Integer[] data) {
        int level = 1;
        TreeNode rootNode = null;
        int position = 0;
        int len = data.length;
        Map<Integer, TreeNode> nodeRecord = new HashMap<>();
        while (position < len) {
            int countBeforeThisLevel = level == 1 ? 0 : 2 * (int) Math.pow(2, level - 2) - 1;
            int currentLevelCount = (int) Math.pow(2.0, level - 1);
            int positionInThisLevel = position - countBeforeThisLevel;
            Integer itemValue = data[position];
            if (itemValue != null) {
                TreeNode node = nodeRecord.get(position) != null ? nodeRecord.get(position) : new TreeNode(itemValue);
                if (position == 0) {
                    rootNode = node;
                }
                int leftChildPosition = 2 * positionInThisLevel + 2 * (int) Math.pow(2, level - 1) - 1;
                int rightChildPosition = leftChildPosition + 1;
                if (leftChildPosition < len) {
                    Integer leftValue = data[leftChildPosition];
                    if (leftValue != null) {
                        TreeNode leftNode = new TreeNode(leftValue);
                        nodeRecord.put(leftValue, leftNode);
                        node.left = leftNode;
                    }
                }
                if (rightChildPosition < len) {
                    Integer rightValue = data[rightChildPosition];
                    if (rightValue != null) {
                        TreeNode rightNode = new TreeNode(rightValue);
                        nodeRecord.put(rightValue, rightNode);
                        node.right = rightNode;
                    }
                }
            }
            if (positionInThisLevel == currentLevelCount) {
                level++;
            }
            position++;
        }
        return rootNode;
    }

    public static void main(String[] args) {
        Integer[] data1 = new Integer[12];
        data1[0] = 0;
        data1[1] = 1;
        data1[2] = 2;
        data1[3] = 3;
        data1[4] = null;
        data1[5] = 5;
        data1[6] = 6;
        data1[7] = 7;
        data1[8] = null;
        data1[9] = null;
        data1[10] = null;
        data1[11] = 11;
        TreeNode node = buildNode(data1);
        System.out.println(node.toString());
    }
}