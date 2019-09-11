package com.zhangke.algorithms.leetcode;

/**
 * 领口公共库
 * <p>
 * Created by ZhangKe on 2019/9/11.
 */
public class Common {

    /**
     * 链表
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 构建一个链表
     *
     * @param node  链表
     * @param value 起始值
     * @param end   结束值
     */
    public static void buildNode(ListNode node, int value, int end) {
        if (value >= end) {
            return;
        }
        node.val = value;
        node.next = new ListNode(value + 1);
        buildNode(node.next, value + 1, end);
    }

    /**
     * 打印链表
     */
    public static void printNode(ListNode node) {
        StringBuilder builder = new StringBuilder();
        ListNode curNode = node;
        while (curNode != null) {
            builder.append(curNode.val);
            builder.append("->");
            curNode = curNode.next;
        }
        System.out.println(builder.substring(0, builder.length() - 2));
    }
}
