package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.data.Node;

/**
 * 430. 扁平化多级双向链表:
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * Created by ZhangKe on 2021/3/10.
 */
public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        Node newHead = new Node();
        dfs(head, newHead);
        System.out.println();
        newHead.next.prev = null;
        return newHead.next;
    }

    private void dfs(Node curNode, Node recordNode) {
        Node child = curNode.child;
        Node next = curNode.next;
        recordNode.next = new Node(curNode.val);
        recordNode.next.prev = recordNode;
        System.out.print(curNode.val + "->");
        if (child != null) {
            dfs(child, recordNode.next);
        }
        Node recordNext = recordNode.next;
        while(recordNext.next != null){
            recordNext = recordNext.next;
        }
        if (next != null) {
            dfs(next, recordNext);
        }
    }

    public static void main(String[] args) {
        case2();
    }

    private static void case1() {
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node head = new Node(1, null, node2, node3);
        FlattenMultilevelDoublyLinkedList ff = new FlattenMultilevelDoublyLinkedList();
        System.out.println(ff.flatten(head).getLinearDesc());
    }

    private static void case2() {
        Node node12 = new Node(12);
        Node node11 = new Node(11, node12);
        node12.prev = node11;

        Node node10 = new Node(10);
        Node node9 = new Node(9, node10);
        node10.prev = node9;
        Node node8 = new Node(8, null, node9, node11);
        node9.prev = node8;

        Node node7 = new Node(7, node8);
        node8.prev = node7;

        Node node6 = new Node(6);
        Node node5 = new Node(5, node6);
        node6.prev = node5;
        Node node4 = new Node(4, node5);
        node5.prev = node4;
        Node node3 = new Node(3, null, node4, node7);
        node4.prev = node3;
        Node node2 = new Node(2, node3);
        node3.prev = node2;
        Node head = new Node(1, node2);
        node2.prev = head;

        FlattenMultilevelDoublyLinkedList ff = new FlattenMultilevelDoublyLinkedList();
        Node result = ff.flatten(head);
        System.out.println(result.getAllDesc());
    }
}
