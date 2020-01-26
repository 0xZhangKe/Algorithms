package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.data.ListNode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * Created by ZhangKe on 2019/11/11.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        ListNode lastSecond = null;
        head = secondNode != null ? secondNode : head;
        while (firstNode != null && secondNode != null) {
            if (lastSecond != null) {
                lastSecond.next = firstNode.next;
            }
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            lastSecond = firstNode;
            firstNode = firstNode.next;
            secondNode = firstNode != null ? firstNode.next : null;
        }
        return head;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Util.printNode(swapNodesInPairs.swapPairs(node1));
    }
}
