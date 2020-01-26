package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.data.ListNode;

/**
 * 23. 合并K个排序链表:
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * Created by ZhangKe on 2019/10/31.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = null;
        ListNode head = null;
        boolean canLoop = true;
        int haveCount;
        int min;
        int minCount;
        while (canLoop) {
            haveCount = 0;
            min = Integer.MAX_VALUE;
            minCount = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode itemNode = lists[i];
                if (itemNode != null) {
                    haveCount++;
                    if (itemNode.val <= min) {
                        min = itemNode.val;
                        minCount++;
                    }
                }
            }
            for (int i = 0; i < lists.length; i++) {
                ListNode itemNode = lists[i];
                if (itemNode != null && itemNode.val <= min) {
                    lists[i] = itemNode.next;
                    if (node == null) {
                        head = new ListNode(min);
                        node = head;
                    } else {
                        ListNode next = new ListNode(min);
                        node.next = next;
                        node = next;
                    }
                }
            }
            canLoop = haveCount > 0;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[3];
        nodes[0] = buildNode1();
        nodes[1] = buildNode2();
        nodes[2] = buildNode3();
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        Util.printNode(mergeKSortedLists.mergeKLists(nodes));
    }

    private static ListNode buildNode1() {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node4;
        node4.next = node5;
        return node1;
    }

    private static ListNode buildNode2() {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node3;
        node3.next = node4;
        return node1;
    }

    private static ListNode buildNode3() {
        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(6);
        return node2;
    }
}
